package com.sample.performance;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;
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

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

public class Plot {

    public static void main(String[] args) {

        AVLPerf avl = new AVLPerf(3, 2);


        XYSeries series1 = new XYSeries("AVL");
        for(int i=0; i<avl.size;++i)
//            series1.add(avl.inputInsert[i], avl.timeInsert[i]);
            series1.add(avl.timeInsert[i], avl.inputInsert[i]);
//        series1.add(8602064, 23533);
//        series1.add(3495591, 9071);
//        series1.add(8439349, 24623);

        XYSeries series2 = new XYSeries("Rabbits");
        series2.add(20, 30);
        series2.add(40, 40);
        series2.add(70, 10);

        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(series1);
//        xyDataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createXYLineChart("TIMES", "MS", "NUMBERS", xyDataset, PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.yellow);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.GREEN);
        plot.setRangeGridlinePaint(Color.orange);
        plot.setAxisOffset(new RectangleInsets(100, 0, 0, 20));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);

        ChartFrame frame = new ChartFrame("ChartFrame", chart);
        frame.setSize(450, 250);
        frame.setVisible(true);

    }

}
