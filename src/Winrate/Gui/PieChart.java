package Winrate.Gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
    public PieChart()
    {

    }
    public ChartPanel Piechart(){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("1.Platz", Integer.valueOf(10));
        pieDataset.setValue("2.Platz", Integer.valueOf(15));
        pieDataset.setValue("3.Platz", Integer.valueOf(10));
        pieDataset.setValue("4.Platz", Integer.valueOf(30));
        pieDataset.setValue("5.Platz", Integer.valueOf(10));
        pieDataset.setValue("6.Platz", Integer.valueOf(10));
        pieDataset.setValue("7.Platz", Integer.valueOf(5));
        pieDataset.setValue("8.Platz", Integer.valueOf(10));

        JFreeChart chart = ChartFactory.createPieChart("Allianzen",pieDataset,true,true,true);



        ChartPanel chartPanel = new ChartPanel(chart);



                return chartPanel;
    }

}
