package com.simbirsoft.simbirbank.service.impl;

import com.simbirsoft.simbirbank.entity.Account;
import com.simbirsoft.simbirbank.entity.Detail;
import com.simbirsoft.simbirbank.exception.NoAccountException;
import com.simbirsoft.simbirbank.exception.NoMoneyException;
import com.simbirsoft.simbirbank.repository.AccountRepository;
import com.simbirsoft.simbirbank.repository.DetailRepository;
import com.simbirsoft.simbirbank.rest.dto.AccountResponseDto;
import com.simbirsoft.simbirbank.rest.dto.DetailRequestDto;
import com.simbirsoft.simbirbank.rest.dto.DetailResponseDto;
import com.simbirsoft.simbirbank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final DetailRepository detailRepository;

    public AccountServiceImpl(AccountRepository accountRepository, DetailRepository detailRepository) {
        this.accountRepository = accountRepository;
        this.detailRepository = detailRepository;
    }

    @Transactional
    @Override
    public AccountResponseDto getBalance(Integer number) {
        Account account = accountRepository.findByNumber(number).orElseThrow(() -> new NoAccountException(String.format("Account number = %d not found", number)));
        return new AccountResponseDto(number, account.getBalance());
    }

    @Transactional
    @Override
    public List<DetailResponseDto> getDetail(Integer number) {
        Account account = accountRepository.findByNumber(number).orElseThrow(() -> new NoAccountException(String.format("Account number = %d not found", number)));
        List<Detail> list = detailRepository.findByAccount(account);
        return list.stream().map((d) -> new DetailResponseDto(d.getTransaction(), d.getDate())).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AccountResponseDto makeOperation(Integer number, DetailRequestDto requestDto) {
        Account account = accountRepository.findByNumber(number).orElseThrow(() -> new NoAccountException(String.format("Account number = %d not found", number)));

        if (account.getBalance() < requestDto.getTransaction()) {
            throw new NoMoneyException(String.format("Client with number %d has not money", number));
        }

        account.setBalance(account.getBalance() + requestDto.getTransaction());
        accountRepository.save(account);

        Detail detail = new Detail();
        detail.setAccount(account);
        detail.setTransaction(requestDto.getTransaction());
        detailRepository.save(detail);

        return new AccountResponseDto(number, account.getBalance());
    }
}
