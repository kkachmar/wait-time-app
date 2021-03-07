
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

    public int GetWaitTime(){
        int Stage1SecondsPerPerson= 75;// the amount of time it takes to get your vial and register your name
        if((int)(Math.random()*1000) == 4){//i in 1000 chance it takes double the time if a messup occurs
            Stage1SecondsPerPerson *= 2;
        }
        int Stage2SecondsPerPerson = 70; //the time time it takes to do the nose swab
        int TimeToWalk = 45;//time to walk from gathering vial to test taking station
        Random Rand = new Random();
        Stage1SecondsPerPerson = (int) (Rand.nextGaussian()*10)+ Stage1SecondsPerPerson;
        Stage2SecondsPerPerson= (int) (Rand.nextGaussian()*10)+Stage2SecondsPerPerson;
        TimeToWalk= (int) (Rand.nextGaussian()*7)+ TimeToWalk;
        int totalTimePerPerson = Stage1SecondsPerPerson + TimeToWalk + Stage2SecondsPerPerson;
        return(totalTimePerPerson);

    }
}
