package com.sample.performance;

import com.google.common.base.Joiner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by souriyakhaosanga on 3/3/14.
 */
public class Csv {
    private static AVLPerf avlPerf;

    public static void main(String[] args) {
        avlPerf = new AVLPerf(100, 1, 100);
        outputFile("file", createString());
    }

    public static String createString() {
        String delimiter = ", ";
        String csv;
        List<String> list1 = new LinkedList<String>();
        for (int i = 0; i < avlPerf.numberOfRepeatTest; ++i) {
            list1.add(String.valueOf(String.valueOf(avlPerf.inputInsert[i]) + delimiter + avlPerf.timeInsert[i]));
        }
        csv = Joiner.on("\n").join(list1);
        return csv;
    }

    public static void outputFile(String fileName, String input) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName + ".txt", "UTF-8");
            writer.println(input);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
