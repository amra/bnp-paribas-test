package com.bnp.service;

import com.bnp.data.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class BondService {

    private static final int MAX_NUMBER_PER_DAY_PER_IP = 5;
    private static final int MAX_NIGHT_AMOUNT = 1000;


    // Client can apply for a bond by providing his personal data, term and amount.
    public Collection<String> buy(User user, String ip, String isin, int amount) {

        validateTime(user, MAX_NIGHT_AMOUNT);
        validateMaxNumberPerDayIp(ip, MAX_NUMBER_PER_DAY_PER_IP);

        return proceedPurchase(user, isin, amount);
    }

    private Collection<String> proceedPurchase(User user, String isin, int amount) {
        // Get Id
        // Issue bond
        // Save UserBonds
        // return list of isin + bond number

        return Collections.emptyList();
    }

    // the application is made between 10:00 PM and 06:00 AM with an amount higher than 1000
    private void validateTime(User user, int amount) {

    }

    // reached max number of sold bonds (e.g. 5) per day from a single IP address
    private void validateMaxNumberPerDayIp(String ip, int maxAmount) {

    }
}
