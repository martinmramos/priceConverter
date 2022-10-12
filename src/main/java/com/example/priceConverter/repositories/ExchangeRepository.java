package com.example.priceConverter.repositories;

import com.example.priceConverter.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ExchangeRepository extends JpaRepository <Exchange, Date> {
}
