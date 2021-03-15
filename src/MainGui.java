/**
 * still need to work on
 * being able to close the error window without closing the whole jframe
 * not printing out the hour total values anymore
 * being able to inisialize the people in the records into the hash map
 * fixing up the logic in check results
 */

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainGui extends JFrame{
    protected Toolbar toolbar;
    protected WaitTimeDisplay waitTimePanel;
    protected ResultsPanel resultsPanel;
    protected StudentRecordReader ReadM;
    protected StudentRecordReader ReadW;

    MainGui() throws IOException {
        super("Wait Time");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,800);
        setLayout(new GridLayout(6,3));

        //add wait time panel
        waitTimePanel = new WaitTimeDisplay(this);
        this.add(waitTimePanel);

        //add results lookup
        resultsPanel = new ResultsPanel(this);
        this.add(resultsPanel);

        setVisible(true);
        StudentRecordCreator RcM = new StudentRecordCreator("MONDAY");
        StudentRecordCreator RcW = new StudentRecordCreator("WEDNESDAY");
         ReadM = new StudentRecordReader("MONDAY");
         ReadW = new StudentRecordReader("WEDNESDAY");

    }


    public void run(int selection) throws IOException {//add a time slot so that i can chose the correct time
        int[] monday = ReadM.ValsOfTimes();
        int[] Wednesday = ReadW.ValsOfTimes();
        NumberGenerator NG = new NumberGenerator(monday, Wednesday);
        //need logic to pick monday or wednesday based on selection
        String day = "";
        if( selection == 1) {
            day = "Monday";
        }
         else{
             day = "Wednesday";
         }   
        int numOfPeople = NG.GetSemiRandomWaitTime(day,"4PM");//test to run the method getSemi
        System.out.println("The amount of people is " + numOfPeople);
        int summer = 0;//summation counter
        for(int i =0; i< numOfPeople; i++){//the total amount of time it takes for every person added up to get tested at a given time
            summer+=NG.GetWaitTime();
        }
        summer = summer/11; // this is for the amount of tables to go to to get tested.
        int totalTime = summer;

        totalTime = totalTime/5;
        DecimalFormat myFormatter = new DecimalFormat("00");
        String mins = myFormatter.format(totalTime/60);
        String Secs = myFormatter.format(totalTime%60);
        waitTimePanel.updateMessage("Your wait time is "+ mins+" Min "+ Secs +" Sec");

    }

    public static void main(String[] args) throws IOException {
       MainGui main = new MainGui();
    }
}
