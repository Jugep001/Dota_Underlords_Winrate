package Winrate.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements Runnable, ActionListener {

    List<JLabel> Alliance_list = new ArrayList<JLabel>();
    List<JTextField> Choices_list = new ArrayList<JTextField>();

    JTextField Second_Choice_Field;
    JTextField First_Choice_Field;

    private String First_Choice = "";
    private String Second_Choice = "";

    private JButton Search;
    private JButton Add;
    private JButton Remove;

    int counter = 0;
    int counter2 = 0;
    int memory = 0;
    int memory2 = 0;

    Image Assassin_img = null;
    Image Brawny_img = null;
    Image Brute_img = null;
    Image Champion_img = null;
    Image Demon_img = null;
    Image Dragon_img = null;
    Image Fallen_img = null;
    Image Healer_img = null;
    Image Heartless_img = null;
    Image Human_img = null;
    Image Hunter_img = null;
    Image Knight_img = null;
    Image Mage_img = null;
    Image Poisoner_img = null;
    Image Rogue_img = null;
    Image Savage_img = null;
    Image Scaled_img = null;
    Image Shaman_img = null;
    Image Spirit_img = null;
    Image Summoner_img = null;
    Image Swordsman_img = null;
    Image Troll_img = null;
    Image Vigilant_img = null;
    Image Warrior_img = null;

    File Alliances_json;

    URL url = null;
    InputStream is = null;


    private class Alliance_Mouse_Handler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent evt) {
            JLabel source = (JLabel) evt.getSource();
            Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
            //JLabel label : Alliance_list
            for (int i = 0; i < Alliance_list.size(); i++) {
                if (Alliance_list.get(i) == source) {

                    if (counter == 0) {
                        if (counter2 != 0) {
                            Alliance_list.get(memory).setBorder(null);
                        }
                        Alliance_list.get(i).setBorder(border);
                        memory = i;
                        counter++;
                        counter2++;
                        Choices_list.get(0).setText(Alliance_list.get(i).getName());
                    } else {
                        if (counter2 != 1) {
                            Alliance_list.get(memory2).setBorder(null);
                        }
                        Alliance_list.get(i).setBorder(border);
                        memory2 = i;
                        counter = 0;
                        counter2 = 3;
                        Choices_list.get(1).setText(Alliance_list.get(i).getName());
                    }


                }
            }
        }
    }



    @Override
    public void run() {
        try {
            url = getClass().getResource("/Assassin.png");
            is = url.openStream();
            Assassin_img = ImageIO.read(is);

            url = getClass().getResource("/Brawny.png");
             is = url.openStream();
            Brawny_img = ImageIO.read(is);

            url = getClass().getResource("/Brute.png");
             is = url.openStream();
            Brute_img = ImageIO.read(is);

            url = getClass().getResource("/Champion.png");
             is = url.openStream();
            Champion_img = ImageIO.read(is);

            url = getClass().getResource("/Demon.png");
             is = url.openStream();
            Demon_img = ImageIO.read(is);

            url = getClass().getResource("/Dragon.png");
             is = url.openStream();
            Dragon_img = ImageIO.read(is);

            url = getClass().getResource("/Fallen.png");
             is = url.openStream();
            Fallen_img = ImageIO.read(is);

            url = getClass().getResource("/Healer.png");
             is = url.openStream();
            Healer_img = ImageIO.read(is);

            url = getClass().getResource("/Heartless.png");
             is = url.openStream();
            Heartless_img = ImageIO.read(is);

            url = getClass().getResource("/Human.png");
             is = url.openStream();
            Human_img = ImageIO.read(is);

            url = getClass().getResource("/Hunter.png");
             is = url.openStream();
            Hunter_img = ImageIO.read(is);

            url = getClass().getResource("/Knight.png");
             is = url.openStream();
            Knight_img = ImageIO.read(is);

            url = getClass().getResource("/Mage.png");
             is = url.openStream();
            Mage_img = ImageIO.read(is);

            url = getClass().getResource("/Poisoner.png");
             is = url.openStream();
            Poisoner_img = ImageIO.read(is);

            url = getClass().getResource("/Rogue.png");
             is = url.openStream();
            Rogue_img = ImageIO.read(is);

            url = getClass().getResource("/Savage.png");
             is = url.openStream();
            Savage_img = ImageIO.read(is);

            url = getClass().getResource("/Scaled.png");
             is = url.openStream();
            Scaled_img = ImageIO.read(is);

            url = getClass().getResource("/Shaman.png");
             is = url.openStream();
            Shaman_img = ImageIO.read(is);

            url = getClass().getResource("/Spirit.png");
             is = url.openStream();
            Spirit_img = ImageIO.read(is);

            url = getClass().getResource("/Summoner.png");
             is = url.openStream();
            Summoner_img = ImageIO.read(is);

            url = getClass().getResource("/Swordsman.png");
             is = url.openStream();
            Swordsman_img = ImageIO.read(is);

            url = getClass().getResource("/Troll.png");
             is = url.openStream();
            Troll_img = ImageIO.read(is);

            url = getClass().getResource("/Vigilant.png");
             is = url.openStream();
            Vigilant_img = ImageIO.read(is);

            url = getClass().getResource("/Warrior.png");
             is = url.openStream();
            Warrior_img = ImageIO.read(is);





        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setTitle("WinrateFinder");
        this.setLayout(new BorderLayout());
        this.add(AlliancePanel());
        this.setSize(900, 450);
        this.setVisible(true);
    }

    private JPanel AlliancePanel() {
        JPanel mainPanel = new JPanel();
        JPanel AlliancesPanel = new JPanel();
        JPanel ChoicesPanel = new JPanel();
        Alliance_Mouse_Handler myMouseHandler = new Alliance_Mouse_Handler();





        ImageIcon Hunter_Icon = new ImageIcon(Hunter_img);

        ImageIcon Knight_Icon = new ImageIcon(Knight_img);
        ImageIcon Brute_Icon = new ImageIcon(Brute_img);
        ImageIcon Assassin_Icon = new ImageIcon(Assassin_img);
        ImageIcon Brawny_Icon = new ImageIcon(Brawny_img);
        ImageIcon Champion_Icon = new ImageIcon(Champion_img);
        ImageIcon Demon_Icon = new ImageIcon(Demon_img);
        ImageIcon Dragon_Icon = new ImageIcon(Dragon_img);
        ImageIcon Fallen_Icon = new ImageIcon(Fallen_img);
        ImageIcon Healer_Icon = new ImageIcon(Healer_img);
        ImageIcon Heartless_Icon = new ImageIcon(Heartless_img);
        ImageIcon Human_Icon = new ImageIcon(Human_img);
        ImageIcon Mage_Icon = new ImageIcon(Mage_img);
        ImageIcon Poisoner_Icon = new ImageIcon(Poisoner_img);
        ImageIcon Rogue_Icon = new ImageIcon(Rogue_img);
        ImageIcon Savage_Icon = new ImageIcon(Savage_img);
        ImageIcon Scaled_Icon = new ImageIcon(Scaled_img);
        ImageIcon Shaman_Icon = new ImageIcon(Shaman_img);
        ImageIcon Spirit_Icon = new ImageIcon(Spirit_img);
        ImageIcon Summoner_Icon = new ImageIcon(Summoner_img);
        ImageIcon Swordsman_Icon = new ImageIcon(Swordsman_img);
        ImageIcon Troll_Icon = new ImageIcon(Troll_img);
        ImageIcon Vigilant_Icon = new ImageIcon(Vigilant_img);
        ImageIcon Warrior_Icon = new ImageIcon(Warrior_img);

        mainPanel.setLayout(new BorderLayout());
        AlliancesPanel.setLayout(new GridBagLayout());
        ChoicesPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Hunter
        JLabel Hunter = new JLabel();
        Hunter.setName("Hunter");
        Hunter.setIcon(Hunter_Icon);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(2, 0, 0, 10);
        Hunter.addMouseListener(myMouseHandler);
        Alliance_list.add(Hunter);
        AlliancesPanel.add(Hunter, gc);

        //Knight
        JLabel Knight = new JLabel();
        Knight.setName("Knight");
        Knight.setIcon(Knight_Icon);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Knight.addMouseListener(myMouseHandler);
        Alliance_list.add(Knight);
        AlliancesPanel.add(Knight, gc);

        //Brute
        JLabel Brute = new JLabel();
        Brute.setName("Brute");
        Brute.setIcon(Brute_Icon);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Brute.addMouseListener(myMouseHandler);
        Alliance_list.add(Brute);
        AlliancesPanel.add(Brute, gc);

        //Champion
        JLabel Champion = new JLabel();
        Champion.setName("Champion");
        Champion.setIcon(Champion_Icon);
        gc.gridx = 3;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Champion.addMouseListener(myMouseHandler);
        Alliance_list.add(Champion);
        AlliancesPanel.add(Champion, gc);

        //Demon
        JLabel Demon = new JLabel();
        Demon.setName("Demon");
        Demon.setIcon(Demon_Icon);
        gc.gridx = 4;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Demon.addMouseListener(myMouseHandler);
        Alliance_list.add(Demon);
        AlliancesPanel.add(Demon, gc);

        //Dragon
        JLabel Dragon = new JLabel();
        Dragon.setName("Dragon");
        Dragon.setIcon(Dragon_Icon);
        gc.gridx = 5;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Dragon.addMouseListener(myMouseHandler);
        Alliance_list.add(Dragon);
        AlliancesPanel.add(Dragon, gc);

        //Fallen
        JLabel Fallen = new JLabel();
        Fallen.setName("Fallen");
        Fallen.setIcon(Fallen_Icon);
        gc.gridx = 6;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Fallen.addMouseListener(myMouseHandler);
        Alliance_list.add(Fallen);
        AlliancesPanel.add(Fallen, gc);

        //Healer
        JLabel Healer = new JLabel();
        Healer.setName("Healer");
        Healer.setIcon(Healer_Icon);
        gc.gridx = 7;
        gc.gridy = 0;
        gc.insets = new Insets(2, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Healer.addMouseListener(myMouseHandler);
        Alliance_list.add(Healer);
        AlliancesPanel.add(Healer, gc);

        //Heartless
        JLabel Heartless = new JLabel();
        Heartless.setName("Heartless");
        Heartless.setIcon(Heartless_Icon);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Heartless.addMouseListener(myMouseHandler);
        Alliance_list.add(Heartless);
        AlliancesPanel.add(Heartless, gc);

        //Human
        JLabel Human = new JLabel();
        Human.setName("Human");
        Human.setIcon(Human_Icon);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Human.addMouseListener(myMouseHandler);
        Alliance_list.add(Human);
        AlliancesPanel.add(Human, gc);

        //Mage
        JLabel Mage = new JLabel();
        Mage.setName("Mage");
        Mage.setIcon(Mage_Icon);
        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Mage.addMouseListener(myMouseHandler);
        Alliance_list.add(Mage);
        AlliancesPanel.add(Mage, gc);

        //Poisoner
        JLabel Poisoner = new JLabel();
        Poisoner.setName("Poisoner");
        Poisoner.setIcon(Poisoner_Icon);
        gc.gridx = 3;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Poisoner.addMouseListener(myMouseHandler);
        Alliance_list.add(Poisoner);
        AlliancesPanel.add(Poisoner, gc);

        //Rogue
        JLabel Rogue = new JLabel();
        Rogue.setName("Rogue");
        Rogue.setIcon(Rogue_Icon);
        gc.gridx = 4;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Rogue.addMouseListener(myMouseHandler);
        Alliance_list.add(Rogue);
        AlliancesPanel.add(Rogue, gc);

        //Savage
        JLabel Savage = new JLabel();
        Savage.setName("Savage");
        Savage.setIcon(Savage_Icon);
        gc.gridx = 5;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Savage.addMouseListener(myMouseHandler);
        Alliance_list.add(Savage);
        AlliancesPanel.add(Savage, gc);

        //Scaled
        JLabel Scaled = new JLabel();
        Scaled.setName("Scaled");
        Scaled.setIcon(Scaled_Icon);
        gc.gridx = 6;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Scaled.addMouseListener(myMouseHandler);
        Alliance_list.add(Scaled);
        AlliancesPanel.add(Scaled, gc);

        //Shaman
        JLabel Shaman = new JLabel();
        Shaman.setName("Shaman");
        Shaman.setIcon(Shaman_Icon);
        gc.gridx = 7;
        gc.gridy = 1;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Shaman.addMouseListener(myMouseHandler);
        Alliance_list.add(Shaman);
        AlliancesPanel.add(Shaman, gc);

        //Spirit
        JLabel Spirit = new JLabel();
        Spirit.setName("Spirit");
        Spirit.setIcon(Spirit_Icon);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Spirit.addMouseListener(myMouseHandler);
        Alliance_list.add(Spirit);
        AlliancesPanel.add(Spirit, gc);

        //Summoner
        JLabel Summoner = new JLabel();
        Summoner.setName("Summoner");
        Summoner.setIcon(Summoner_Icon);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Summoner.addMouseListener(myMouseHandler);
        Alliance_list.add(Summoner);
        AlliancesPanel.add(Summoner, gc);

        //Swordsman
        JLabel Swordsman = new JLabel();
        Swordsman.setName("Swordsman");
        Swordsman.setIcon(Swordsman_Icon);
        gc.gridx = 2;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Swordsman.addMouseListener(myMouseHandler);
        Alliance_list.add(Swordsman);
        AlliancesPanel.add(Swordsman, gc);

        //Troll
        JLabel Troll = new JLabel();
        Troll.setName("Troll");
        Troll.setIcon(Troll_Icon);
        gc.gridx = 3;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Troll.addMouseListener(myMouseHandler);
        Alliance_list.add(Troll);
        AlliancesPanel.add(Troll, gc);

        //Vigilant
        JLabel Vigilant = new JLabel();
        Vigilant.setName("Vigilant");
        Vigilant.setIcon(Vigilant_Icon);
        gc.gridx = 4;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Vigilant.addMouseListener(myMouseHandler);
        Alliance_list.add(Vigilant);
        AlliancesPanel.add(Vigilant, gc);

        //Warrior
        JLabel Warrior = new JLabel();
        Warrior.setName("Warrior");
        Warrior.setIcon(Warrior_Icon);
        gc.gridx = 5;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Warrior.addMouseListener(myMouseHandler);
        Alliance_list.add(Warrior);
        AlliancesPanel.add(Warrior, gc);

        //Brawny
        JLabel Brawny = new JLabel();
        Brawny.setName("Brawny");
        Brawny.setIcon(Brawny_Icon);
        gc.gridx = 6;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        Brawny.addMouseListener(myMouseHandler);
        Alliance_list.add(Brawny);
        AlliancesPanel.add(Brawny, gc);

        //Assassin
        JLabel Assassin = new JLabel();
        Assassin.setName("Assassin");
        Assassin.setIcon(Assassin_Icon);
        gc.gridx = 7;
        gc.gridy = 2;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = 1;
        gc.weighty = 1;
        Assassin.addMouseListener(myMouseHandler);
        Alliance_list.add(Assassin);
        AlliancesPanel.add(Assassin, gc);

        First_Choice_Field = new JTextField();
        First_Choice_Field.setPreferredSize(new Dimension(200, 28));
        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(20, 150, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        Choices_list.add(First_Choice_Field);
        ChoicesPanel.add(First_Choice_Field, gc);

        JLabel connector = new JLabel("+");
        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(25, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        ChoicesPanel.add(connector, gc);

        Second_Choice_Field = new JTextField();
        Second_Choice_Field.setPreferredSize(new Dimension(200, 28));
        gc.gridx = 3;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        Choices_list.add(Second_Choice_Field);
        ChoicesPanel.add(Second_Choice_Field, gc);

        Search = new JButton("Search");
        gc.gridx = 4;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        Search.addActionListener(this);
        ChoicesPanel.add(Search, gc);

        Add = new JButton("Add");
        gc.gridx = 5;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        Add.addActionListener(this);
        ChoicesPanel.add(Add, gc);

        Remove = new JButton("Remove last Entry");
        gc.gridx = 6;
        gc.gridy = 0;
        gc.insets = new Insets(20, 0, 0, 10);
        gc.anchor = GridBagConstraints.NORTH;
        Remove.addActionListener(this);
        ChoicesPanel.add(Remove, gc);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(AlliancesPanel, BorderLayout.NORTH);
        mainPanel.add(ChoicesPanel, BorderLayout.WEST);
        add(mainPanel);
        getContentPane().revalidate();
        return mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add) {
            if (First_Choice_Field.getText().isEmpty() == true || Second_Choice_Field.getText().isEmpty() == true) {
                warning.infoBox("Keines der Beiden Felder darf leer sein", "warning");
                return;
            }


            this.First_Choice = First_Choice_Field.getText();
            this.Second_Choice = Second_Choice_Field.getText();


            Placing placing = new Placing(First_Choice, Second_Choice);

        } else if (e.getSource() == Search) {
            if (First_Choice_Field.getText().isEmpty() == true || Second_Choice_Field.getText().isEmpty() == true) {
                warning.infoBox("Keines der Beiden Felder darf leer sein", "warning");
                return;
            }
            else{

                try {

                    Search search = new Search(First_Choice_Field.getText(),Second_Choice_Field.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }


        } else if (e.getSource() == Remove) {
            byte b = 0;
            RandomAccessFile f = null;
            File file = new File("./Alliances.json");
            if(file.length() == 0){
                warning.infoBox("Datei ist leer","warning");
                return;
            }
            warning.infoBox("letzte Allianz erfolgreich gelöscht","Erfolg");
            try {
                f = new RandomAccessFile(file, "rw");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            long length = 0;
            try {
                length = f.length() - 1;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            do {
                length -= 1;
                try {
                    f.seek(length);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    b = f.readByte();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } while(b != 10 && length > 0);
            if (length == 0) {
                try {
                    f.setLength(length);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                try {
                    f.setLength(length + 1);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) {
        Window w = new Window();

        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        w.run();
    }
}
