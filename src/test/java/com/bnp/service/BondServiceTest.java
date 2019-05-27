package com.bnp.service;

import com.bnp.data.Bond;
import com.bnp.data.User;
import com.bnp.data.UserBond;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.junit.Assert.*;

public class BondServiceTest {

    @Autowired
    private BondService bondService;

    @Test
    public void proceedPurchase() {
        User user = null;
        Bond bond = null;

        Collection<UserBond> userBonds = bondService.proceedPurchase(user, bond, 1);

        assertEquals(1, userBonds.size());
    }
}