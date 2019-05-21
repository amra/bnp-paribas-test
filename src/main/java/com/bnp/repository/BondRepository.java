package com.bnp.repository;

import com.bnp.data.Bond;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface used for accessing the data in database.
 */
public interface BondRepository extends CrudRepository<Bond, Long> {

}
