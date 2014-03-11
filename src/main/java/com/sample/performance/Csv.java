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
    private static AVLMetrics avlInsert, avlFind, avlDelete;
    private static HashtableMetrics hashInsert, hashDelete, hashFound;

    public static void main(String[] args) {
        avlInsert = new AVLMetrics();
        avlInsert.testOfInsertion(1, 10000, 1000001);
        String csv = createString(avlInsert);
        outputFile("AVLinsert", csv);

        avlDelete = new AVLMetrics();
        avlDelete.testOfDeletions(1, 10000, 1000001);
        String csv1 = createString(avlDelete);
        outputFile("AVL_delete",csv1);

        avlFind = new AVLMetrics();
        avlFind.testOfFounds(1, 10000, 1000001);
        String csv2 = createString(avlFind);
        outputFile("AVL_find",csv2);

        hashInsert = new HashtableMetrics();
        hashInsert.testOfInsertion(100000, 1, 10000, 1000001);
        String csv4 = createString(hashInsert);
        outputFile("Hashinsert", csv4);

        hashDelete = new HashtableMetrics();
        hashDelete.testOfDeletions(1000, 1, 10000, 1000001);
        String csv5 = createString(hashDelete);
        outputFile("Hash_delete", csv5);

        hashFound = new HashtableMetrics();
        hashFound.testOfFound(1000, 1, 10000, 1000001);
        String csv6 = createString(hashFound);
        outputFile("Hash_found", csv6);
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
