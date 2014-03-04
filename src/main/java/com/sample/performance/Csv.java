package com.sample.performance;

import com.google.common.base.Joiner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by souriyakhaosanga on 3/3/14.
 */
public class Csv {
    private static AVLPerf avlPerf;

    public static void main(String[] args) {
        avlPerf = new AVLPerf(100, 1, 1);
        createString();
    }
    public static void createString(){
        List<String> list1 = new LinkedList<String>();
        for (int i = 0; i < avlPerf.numberOfRepeatTest; ++i){
                list1.add(String.valueOf(avlPerf.timeInsert[i])+"   "+String.valueOf(avlPerf.inputInsert[i]));
            }
            String csv = Joiner.on("\n").join(list1);
        System.out.println(csv);
    }
}
