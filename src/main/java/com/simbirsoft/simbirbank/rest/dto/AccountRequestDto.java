package com.simbirsoft.simbirbank.rest.dto;

public class AccountRequestDto {

    private Integer number;

    public AccountRequestDto() {
    }

    public AccountRequestDto(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
