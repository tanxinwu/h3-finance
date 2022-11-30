package com.base.finance.devise.pattern.strategy;

/**
 * 打五折
 */
public class HalfDiscountStrategy extends  AbstractStrategy{
    @Override
    public boolean isMatch(Integer channel) {
        return Integer.valueOf(2).equals(channel);
    }

    @Override
    public double settle(double money) {
        return money * 0.5D;
    }
}
