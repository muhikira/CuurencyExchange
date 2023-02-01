package com.bk.repository;

import com.bk.model.ForexExchangeConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForexExchangeConversionRepository extends JpaRepository<ForexExchangeConversion,Long> {
}
