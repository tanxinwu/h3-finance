package com.base.finance.devise.pattern.responsibility.link;

public class Test {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        //第一次请求info日志
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        //第二次请求debug日志
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        //第三次请求error日志
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
