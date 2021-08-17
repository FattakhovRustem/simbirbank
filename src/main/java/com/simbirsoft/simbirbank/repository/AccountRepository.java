package com.simbirsoft.simbirbank.repository;

import com.simbirsoft.simbirbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByNumber(Integer number);
}
