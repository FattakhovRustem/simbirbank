package com.simbirsoft.simbirbank.repository;

import com.simbirsoft.simbirbank.entity.Account;
import com.simbirsoft.simbirbank.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    List<Detail> findByAccount(Account account);
}
