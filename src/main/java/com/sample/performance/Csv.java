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
    private static AVLMetrics test;
    private static HashtableMetrics test1;

    public static void main(String[] args) {
        test = new AVLMetrics();
        test.testOfInsertion(10000,100,50000);
        String csv = createString(test);
        outputFile("test",csv);

        test1 = new HashtableMetrics();
        test1.testOfInsertion(0, 100, 5000);
        String csv1 = createString(test1);
        outputFile("test1", csv);

    }

    public static String createString(Metrics metrics) {
        String delimiter = ",";
        String csv;
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < metrics.numberOfElements.size(); ++i) {
            list.add(String.valueOf(String.valueOf(metrics.getNumberOfElements().get(i)) +
                    delimiter + String.valueOf(metrics.getTimeForOperation().get(i))));
        }
        csv = Joiner.on("\n").join(list);
        return csv;
    }

    public static void outputFile(String fileName, String input) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName + ".csv", "UTF-8");
            writer.println(input);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
