package com.base.finance.devise.pattern.strategy;

/**
 * 购物满300减50元
 */
public class FulfilThreeHundredReduceFiftyStrategy extends  AbstractStrategy{
    @Override
    public boolean isMatch(Integer channel) {
        return Integer.valueOf(3).equals(channel);
    }

    @Override
    public double settle(double money) {
        return money  >=  300 ? money -50 : money;
    }
}
