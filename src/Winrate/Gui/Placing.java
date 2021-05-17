package Winrate.Gui;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Placing extends JFrame implements ActionListener {

    JButton confirm;
    JComboBox ComboBox_Placing_Choice;
    private String First_Choice,Second_Choice,Placing;

    private Integer ComboBox_Placing[] = {1,2,3,4,5,6,7,8};



    public Placing(String First_Choice,String Second_Choice){
        this.First_Choice = First_Choice;
        this.Second_Choice = Second_Choice;


        JPanel Placing_Panel = new JPanel();
        JPanel Placing_Button_Panel = new JPanel();
        confirm = new JButton("confirm");
        JLabel Placing_Question = new JLabel("Welcher Platz wurdest du?");



        ComboBox_Placing_Choice = new JComboBox(ComboBox_Placing);


        Placing_Panel.add(Placing_Question);
        Placing_Panel.add(ComboBox_Placing_Choice);
        Placing_Button_Panel.add(confirm);
        confirm.addActionListener(this);

        this.setSize(300,110);
        this.add(Placing_Panel,BorderLayout.NORTH);
        this.add(Placing_Button_Panel,BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Placing Choice");
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirm){
            this.dispose();
            try {
                writeJsonAlliance("./Alliances.json");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

    }

    public void writeJsonAlliance(String filename) throws Exception {
        this.Placing = ComboBox_Placing_Choice.getSelectedItem().toString();
        FileWriter file = new FileWriter(filename,true);

        JSONObject AllianceDetails = new JSONObject();
        AllianceDetails.put("First_Choice", this.First_Choice);
        AllianceDetails.put("Second_Choice", this.Second_Choice );
        AllianceDetails.put("Placing", this.Placing);

        JSONObject AllianceObject = new JSONObject();
        AllianceObject.put("Alliance", AllianceDetails);


        JSONArray AllianceList = new JSONArray();
        AllianceList.add(AllianceObject);


        try (BufferedWriter bw = new BufferedWriter(file)) {

            bw.write(AllianceList.toJSONString());
            bw.newLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
