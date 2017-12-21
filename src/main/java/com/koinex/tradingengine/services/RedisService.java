package com.koinex.tradingengine.services;

import com.koinex.tradingengine.implementors.SortedSetImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisService {

    @Autowired
    SortedSetImpl sortedSet;

    public void performRedisOperation(){
        Double a =65.0;

        sortedSet.save(a,a);
        System.out.println(sortedSet.update(a));
        System.out.println(sortedSet.findAllElements());
    }

}
