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

public class Plot {
    public static void main(String[] args) {
    AVLMetrics avlMetrics = new AVLMetrics();
    HashtableMetrics hashtable = new HashtableMetrics();

    buildPlot(avlMetrics.testOfInsertion(0, 1000, 100000));
    buildPlot(avlMetrics.testOfDeletions(0, 1000, 100000));
    buildPlot(avlMetrics.testOfFounds(0, 1000, 100000));
    buildPlot(hashtable.testOfInsertion(1000, 0, 100, 10000));
    buildPlot(hashtable.testOfDeletions(1000, 0, 100, 10000));
    buildPlot(hashtable.testOfFound(1000, 0, 100, 100000));

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