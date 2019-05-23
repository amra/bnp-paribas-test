package com.bnp.data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Bond {

    @Id
    @GeneratedValue
    private long id;

    @Unique
    private String isin;

    private String description;

    // In months.
    private int defaultTerm = 60;

    private double defaultCoupon = 0.05;

    private int price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDefaultTerm() {
        return defaultTerm;
    }

    public void setDefaultTerm(int defaultTerm) {
        this.defaultTerm = defaultTerm;
    }

    public double getDefaultCoupon() {
        return defaultCoupon;
    }

    public void setDefaultCoupon(double defaultCoupon) {
        this.defaultCoupon = defaultCoupon;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
