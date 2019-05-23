package com.bnp.repository;

import com.bnp.data.UserBond;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface used for accessing the data in database.
 */
public interface UserBondRepository extends CrudRepository<UserBond, Long> {

}
