package Winrate.Gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Search extends JFrame {
    private double Placing_int_sum;
    private double counter = 0;
    private final String First_Choice;
    private final String Second_Choice;
    int first=0,second=0,third=0,fourth=0,fifth=0,sixth=0,seventh=0,eighth=0;

    public Search(String First_Choice, String Second_Choice) throws FileNotFoundException {

        this.First_Choice = First_Choice;
        this.Second_Choice = Second_Choice;

        JPanel sta_Panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        JLabel Average_Label = new JLabel();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(2, 0, 0, 10);
        sta_Panel.add(Average_Label,gc);

        JLabel WinChance_Label = new JLabel();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(2, 0, 0, 10);
        sta_Panel.add(WinChance_Label,gc);

        double endcounter = parse();
        String Average = String.valueOf(Placing_Average(endcounter));
        Average_Label.setText("Durchschnittliche Platzierung: " + Average);
        Average_Label.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        WinChance_Label.setText("Gewinnchance: " + Winning_Chance());
        WinChance_Label.setFont(new Font("Helvetica Neue", Font.BOLD, 14));

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        if(this.first != 0)
        pieDataset.setValue("1.Platz", this.first);
        if(this.second != 0)
        pieDataset.setValue("2.Platz", this.second);
        if(this.third != 0)
        pieDataset.setValue("3.Platz", this.third);
        if(this.fourth != 0)
        pieDataset.setValue("4.Platz", this.fourth);
        if(this.fifth != 0)
        pieDataset.setValue("5.Platz", this.fifth);
        if(this.sixth != 0)
        pieDataset.setValue("6.Platz", this.sixth);
        if(this.seventh != 0)
        pieDataset.setValue("7.Platz", this.seventh);
        if(this.eighth != 0)
        pieDataset.setValue("8.Platz", this.eighth);
        JFreeChart chart = ChartFactory.createPieChart("Allianzen:" + this.First_Choice + " + " + this.Second_Choice ,pieDataset,true,true,true);
        PiePlot plot = (PiePlot) chart.getPlot();


        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0} = {2}");
        plot.setLabelGenerator(gen);
        ChartPanel chartPanel = new ChartPanel(chart,300,300,300,300,300,300,false,true,true,true,true,true,true);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(2, 0, 0, 10);
        sta_Panel.add(chartPanel,gc);


        this.add(sta_Panel,BorderLayout.NORTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Search");
        this.setSize(400, 400);
        this.setVisible(true);



    }

    public double parse() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        FileReader file = new FileReader("./Alliances.json");
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(file);

            while ((sCurrentLine = br.readLine()) != null) {


                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONArray AllianceList = (JSONArray) obj;



                    AllianceList.forEach(Ali -> parseAllianceObject( (JSONObject) Ali ) );



                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)

                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.counter;
    }

    private void parseAllianceObject(JSONObject Alliance)
    {


        JSONObject AllianceObject = (JSONObject) Alliance.get("Alliance");

    if(((String) AllianceObject.get("First_Choice")).equals(this.First_Choice) && ((String) AllianceObject.get("Second_Choice")).equals(this.Second_Choice)){
        String First_Choice = (String) AllianceObject.get("First_Choice");
        //System.out.println(First_Choice);

        String Second_Choice = (String) AllianceObject.get("Second_Choice");
        //System.out.println(Second_Choice);

        String Placing = (String) AllianceObject.get("Placing");
        int Placing_int = Integer.parseInt(Placing);

        switch(Placing_int){
            case 1:
                this.first++;
                break;
            case 2:
                this.second++;
                break;
            case 3:
                this.third++;
                break;
            case 4:
                this.fourth++;
                break;
            case 5:
                this.fifth++;
                break;
            case 6:
                this.sixth++;
                break;
            case 7:
                this.seventh++;
                break;
            case 8:
                this.eighth++;
                break;
            default:
                break;
        }
        Placing_int_sum = Placing_int_sum + Placing_int;
        //System.out.println(Placing_int_sum);
        this.counter++;
    }
    return;
    }

    private double Placing_Average(double counter){

        return Placing_int_sum/counter;
    }

    private String Winning_Chance(){
        if(Placing_Average(this.counter) > 6){
            return "Niedrig";
        }
        else if(Placing_Average(this.counter) >= 4 && Placing_Average(this.counter) <= 6){
            return "Mittel";
        }
         else if(Placing_Average(this.counter) < 4 && Placing_Average(this.counter) > 0){
            return "Hoch";
        }
         else{
             System.out.println(Placing_Average(this.counter));
             return "NaN";
        }

    }
}
