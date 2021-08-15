package com.simbirsoft.simbirbank.rest.dto;

import java.time.LocalDateTime;

public class DetailResponseDto {

    private Long transaction;

    private LocalDateTime date;

    public DetailResponseDto() {
    }

    public DetailResponseDto(Long transaction, LocalDateTime date) {
        this.transaction = transaction;
        this.date = date;
    }

    public Long getTransaction() {
        return transaction;
    }

    public void setTransaction(Long transaction) {
        this.transaction = transaction;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
