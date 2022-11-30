package com.base.finance.devise.pattern.strategy;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * 策略的上下文，对外提供服务
 */
public class Context {

    private AbstractStrategy abstractStrategy;

    public Context(Integer channel){
        Reflections reflections = new Reflections("com.base.finance.strategy");
        try{
            //获取继承了ISuperClass的所有类
            Set<Class<? extends AbstractStrategy>> subclass  = reflections.getSubTypesOf(AbstractStrategy.class);
            for (Class<? extends AbstractStrategy> subClazz: subclass){
                Constructor<? extends AbstractStrategy> constructor = subClazz.getConstructor();
                constructor.setAccessible(true);
                AbstractStrategy newInstance = constructor.newInstance();
                if (newInstance.isMatch(channel)){
                    abstractStrategy = newInstance;
                    break;
                }
            }
        }catch (Exception ex){                                                                         
            ex.printStackTrace();
        }
    }


    public double settle(double money){
        return  abstractStrategy.settle(money);
    }
}
