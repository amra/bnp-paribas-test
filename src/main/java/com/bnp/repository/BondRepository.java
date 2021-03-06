package com.bnp.repository;

import com.bnp.data.Bond;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Spring data repository interface used for accessing the data in database.
 */
public interface BondRepository extends CrudRepository<Bond, Long> {

    Optional<Bond> findByIsin(String isin);
}
