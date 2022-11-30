package com.base.finance.devise.pattern.strategy;

/**
 * 购物满100减10元
 */
public class FulfilHundredReduceTenStrategy extends  AbstractStrategy{
    @Override
    public boolean isMatch(Integer channel) {
        return Integer.valueOf(1).equals(channel);
    }

    @Override
    public double settle(double money) {
        return money  >=  100 ? money -10 : money;
    }
}
