package Winrate.Gui;

public class Alliance {


    private final String First_Choice;
    private final String Second_Choice;
    private final String Placing;

    public Alliance(String First_Choice, String Second_Choice, String Placing)
    {

        this.First_Choice = First_Choice;
        this.Second_Choice = Second_Choice;
        this.Placing = Placing;

    }

    public String getFirst_Choice() {
        return this.First_Choice;
    }
    public String getSecond_Choice() {
        return this.Second_Choice;
    }
    public String getPlacing() {
        return this.Placing;
    }
}
