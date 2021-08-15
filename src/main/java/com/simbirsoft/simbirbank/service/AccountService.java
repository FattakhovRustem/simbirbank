package com.simbirsoft.simbirbank.service;

import com.simbirsoft.simbirbank.rest.dto.AccountResponseDto;
import com.simbirsoft.simbirbank.rest.dto.DetailRequestDto;
import com.simbirsoft.simbirbank.rest.dto.DetailResponseDto;

import java.util.List;

public interface AccountService {

    AccountResponseDto getBalance(Integer number);

    List<DetailResponseDto> getDetail(Integer number);

    AccountResponseDto makeOperation(Integer number, DetailRequestDto requestDto);
}
