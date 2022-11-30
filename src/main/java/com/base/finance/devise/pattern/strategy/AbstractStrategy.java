package com.base.finance.devise.pattern.strategy;

/**
 * 抽象策略，定义具体的功能
 */
public abstract  class AbstractStrategy {

    public abstract boolean isMatch(Integer channel);
    public abstract double settle(double money);

}
