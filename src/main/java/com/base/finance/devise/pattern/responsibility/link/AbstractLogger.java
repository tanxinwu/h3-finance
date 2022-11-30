package com.base.finance.devise.pattern.responsibility.link;

/**
 * 抽象日志类，有一个next指针指向下一个日志类，有一个基本的日志方法
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        //在链路中找到满足条件条件的节点，让节点执行write方法
        if(this.level <= level){
            write(message);
        }
        //回调，从头结点开始遍历，所有满足条件的节点都会执行write方法
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * 子类实现，具体的内容
     * @param message
     */
    abstract protected void write(String message);

}
