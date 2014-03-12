package com.sample.performance;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.util.Hashtable;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

public class Plot extends Thread{
    public static void main(String[] args) {

        final AVLMetrics avlMetrics1 = new AVLMetrics();
        final AVLMetrics avlMetrics2 = new AVLMetrics();
        final AVLMetrics avlMetrics3 = new AVLMetrics();

        final HashtableMetrics hashtable1 = new HashtableMetrics();
        final HashtableMetrics hashtable2 = new HashtableMetrics();
        final HashtableMetrics hashtable3 = new HashtableMetrics();

        Csv thread1 = new Csv() {
            public void run() {
                buildPlot(avlMetrics1.testOfInsertion(0, 1000, 100000));
            }
        };
        Csv thread2 = new Csv() {
            public void run() {
                buildPlot(avlMetrics2.testOfDeletions(0, 1000, 100000));
            }
        };
        Csv thread3 = new Csv() {
            public void run() {
                buildPlot(avlMetrics3.testOfDeletions(0, 1000, 100000));
            }
        };
        Csv thread4 = new Csv(){
            public void run() {
                buildPlot(hashtable1.testOfInsertion(1000, 0, 100, 10000));
            }

        };
        Csv thread5 = new Csv(){
            public void run() {
                buildPlot(hashtable2.testOfInsertion(1000, 0, 100, 10000));
            }

        };
        Csv thread6 = new Csv(){
            public void run() {
                buildPlot(hashtable3.testOfInsertion(1000, 0, 100, 10000));
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

}


    public static void buildPlot(Metrics metrics){

        XYSeries series1 = new XYSeries(Metrics.nameOfTest);
        for (int i = 0; i < metrics.numberOfElements.size(); ++i){
            series1.add(metrics.getNumberOfElements().get(i), metrics.getTimeForOperation().get(i));
        }

        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(series1);

        JFreeChart chart = ChartFactory.createXYLineChart("Times complexity of "+Metrics.typeOfTest, "Numbers", "Times", xyDataset, PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.yellow);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.GREEN);
        plot.setRangeGridlinePaint(Color.orange);
        plot.setAxisOffset(new RectangleInsets(100, 0, 0, 200));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);

        ChartFrame frame = new ChartFrame("ChartFrame", chart);
        frame.setSize(4500, 2500);
        frame.setVisible(true);

    }
}