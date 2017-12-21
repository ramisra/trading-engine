package com.koinex.tradingengine.interfaces;

import java.util.Map;
import java.util.Set;

public  interface RedisInterface{

    public Object save(Object o);

    Object save(Object o, Double score);

    public Object update(Object o);
    public Object findByElement(String e);
    public Set<Object> findAllElements();
    public void delete(String s);

    Set<Object> findByElement(long start, long end);

    Set<Object> findAllElements(Double min, Double max);
}