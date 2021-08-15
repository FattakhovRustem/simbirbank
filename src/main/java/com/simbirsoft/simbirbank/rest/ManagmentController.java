package com.simbirsoft.simbirbank.rest;

import com.simbirsoft.simbirbank.rest.dto.AccountResponseDto;
import com.simbirsoft.simbirbank.rest.dto.DetailRequestDto;
import com.simbirsoft.simbirbank.rest.dto.DetailResponseDto;
import com.simbirsoft.simbirbank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class ManagmentController {

    private final AccountService accountService;

    public ManagmentController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Получить баланс лицевого счета
    @GetMapping(value = "/{number}/balance")
    public ResponseEntity<AccountResponseDto> getBalanceAccount(@PathVariable Integer number) {
        return ResponseEntity.ok().body(accountService.getBalance(number));
    }

    // Получить список транзакций лицевого счета
    @GetMapping(value = "/{number}/detail")
    public ResponseEntity<List<DetailResponseDto>> getDetailAccount(@PathVariable Integer number) {
        return ResponseEntity.ok().body(accountService.getDetail(number));
    }

    // Положить/снять деньги на лицевой счет
    @PutMapping(value = "/{number}/operation")
    public ResponseEntity<AccountResponseDto> makeOperation(@PathVariable Integer number, @RequestBody DetailRequestDto requestDto) {
        return ResponseEntity.ok().body(accountService.makeOperation(number, requestDto));
    }

}
