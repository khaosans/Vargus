package com.sample.performance;

import java.util.List;

/**
 * Created by solus on 3/4/14.
 */
public class Metrics {
    protected List<Long> numberOfElements;
    protected List<Long> timeForOperation;
    protected static String nameOfTest;
    protected static String typeOfTest;

    public List<Long> getNumberOfElements(){
        return numberOfElements;
    }

    public List<Long> getTimeForOperation(){
        return timeForOperation;
    }
}
