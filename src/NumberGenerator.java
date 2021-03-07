import java.math.*;

import java.util.Date;
import java.util.Random;

public class NumberGenerator {
    int[] Monday = new int[7];
    int[] Wednesday = new int[7];

    public NumberGenerator(int[] monday, int[] wednesday) {//inisialize the time intervals for the amount of people on line at the testing center
        Monday =monday;
        Wednesday = wednesday;
    }

    public int GetSemiRandomWaitTime(String Day, int Time){
        boolean Err = false;
        int[] curDay = {0,0,0,0,0,0,0};// inisialize the variable for the day of testing
        switch(Day.toUpperCase()) {
            case "MONDAY":
                curDay = Monday;
                break;
            case "WEDNESDAY":
                curDay =  Wednesday;
                break;
            default:
                Err = true;
                System.err.println("you have entered a wrong day");
                return -1;
        }
        if(Time == -2){//idealy this would be for using the actual time
            Date curTime = new Date();
            System.out.println(curTime.getTime());
        }
        if(Time == -1){//since you selected -1 A random timeslot will be selected
            int timeSlot = (int)(Math.random()*7);
            int TimeAmt = curDay[timeSlot];
            Random Rand = new Random();
            System.out.println("the day selected is "+ Day.toUpperCase()+" and the time chosen was "+timeSlot+" with the normal amount of people being "+ TimeAmt);
           return (int) (Rand.nextGaussian()*5)+TimeAmt;


        }
            else{
                System.out.println(Time);

        }






        return 0;
    }
}
