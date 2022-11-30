package com.base.finance.devise.pattern.responsibility.link;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Debug::Logger: " + message);
    }
}
