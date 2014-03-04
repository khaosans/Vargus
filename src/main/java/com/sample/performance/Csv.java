package com.sample.performance;

import com.google.common.base.Joiner;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by souriyakhaosanga on 3/3/14.
 */
public class Csv {
    private static AVLPerf avlPerf;

    public static void main(String[] args) {
        avlPerf = new AVLPerf(10,4);
        createString();
    }
    public static void createString(){
        List<String> list1 = new LinkedList<String>();
        for (int i = 0; i < avlPerf.size; ++i){
            for(int j =0; j<10;++j){
                list1.add(String.valueOf(avlPerf.timeInsert[j])+"   "+String.valueOf(avlPerf.inputInsert[j]));
            }
        }
            String csv = Joiner.on("\n").join(list1);
        System.out.println(csv);
    }
}
