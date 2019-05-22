package com.bnp.data;

public class Bond {

    private long id;

    private String isin;

    private String description;

    // In months.
    private int defaultTerm = 60;

    private double defaultCoupon = 0.05;

    private int price;
}
