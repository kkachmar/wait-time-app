import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame{
    protected Toolbar toolbar;

    MainGui(){
        super("Wait Time");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,800);
        setLayout(new BorderLayout());

        toolbar = new Toolbar(this);
        this.add(toolbar, BorderLayout.NORTH);

        setVisible(true);

    }


    public void run(int selection){
        int[] monday = {30, 18, 55, 43, 10, 32, 20};
        int[] Wednesday = {40,33,65,42,35,45,15};
        NumberGenerator NG = new NumberGenerator(monday, Wednesday);
        //need logic to pick monday or wednesday based on selection
        String day = "";
        if( selection == 1){
            day = "Monday";
           
         else{
             day = "Wednesday"
         }   
        int numOfPeople = NG.GetSemiRandomWaitTime(day,-1);//test to run the method getSemi
        System.out.println("The amount of people is " + numOfPeople);
        int summer = 0;//summation counter
        for(int i =0; i< numOfPeople; i++){//the total amount of time it takes for every person added up to get tested at a given time
            summer+=NG.GetWaitTime();
        }
        summer = summer/11; // this is for the amount of tables to go to to get tested.
        int totalTime = summer;
        System.out.println("Your wait time is "+ (totalTime/60)+":"+ totalTime%60);
    }

    public static void main(String[] args){
       MainGui main = new MainGui();
       main.run(1);

    }
}
