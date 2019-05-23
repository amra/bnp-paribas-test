package com.bnp.service;

import com.bnp.data.Bond;
import com.bnp.data.User;
import com.bnp.data.UserBond;
import com.bnp.repository.BondRepository;
import com.bnp.repository.UserBondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BondService {

    private static final int MAX_NUMBER_PER_DAY_PER_IP = 5;
    private static final int MAX_NIGHT_AMOUNT = 1000;

    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private UserBondRepository userBondRepository;

    // Client can apply for a bond by providing his personal data, term and amount.
    public Collection<String> buy(User user, String ip, String isin, int amount) {

        validateTime(user, MAX_NIGHT_AMOUNT);
        validateMaxNumberPerDayIp(ip, MAX_NUMBER_PER_DAY_PER_IP);

        Optional<Bond> bond = bondRepository.findByIsin(isin);
        if (!bond.isPresent()) {
            throw new RuntimeException("Bond ISIN not found.");
        }

        Collection<UserBond> userBonds = proceedPurchase(user, bond.get(), amount);
        return userBonds.stream().map(ub -> ub.getIsin() + "-" + ub.getNumber()).collect(Collectors.toList());
    }

    Collection<UserBond> proceedPurchase(User user, Bond bond, int amount) {
        List<UserBond> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            UserBond userBond = new UserBond();
            userBond.setBond(bond);
            userBond.setUser(user);
            userBond.setBuyDate(new Date(System.currentTimeMillis()));
            userBond.setCurrentCoupon(bond.getDefaultCoupon());
            userBond.setCurrentTerm(bond.getDefaultTerm());
            userBond.setIsin(bond.getIsin());
            userBond.setNumber(generateBondNumber());
            userBond.setPrice(bond.getPrice());

            userBond = userBondRepository.save(userBond);
            result.add(userBond);
        }
        return result;
    }

    // the application is made between 10:00 PM and 06:00 AM with an amount higher than 1000
    private void validateTime(User user, int amount) {

    }

    // reached max number of sold bonds (e.g. 5) per day from a single IP address
    private void validateMaxNumberPerDayIp(String ip, int maxAmount) {

    }

    private String generateBondNumber() {
        return new String (DigestUtils.md5Digest(new Date(System.currentTimeMillis()).toString().getBytes()));
    }
}
