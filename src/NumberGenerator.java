
import java.util.Date;
import java.util.Random;

public class NumberGenerator {

    int[] Monday = new int[7];
    int[] Wednesday = new int[7];

    public NumberGenerator(int[] monday, int[] wednesday) {//initialize the time intervals for the amount of people on line at the testing center
        Monday =monday;
        Wednesday = wednesday;
    }

    public int GetSemiRandomWaitTime(String Day, String Time){
        boolean Err = false;
        int[] curDay = {0,0,0,0,0,0,0};// inisialize the variable for the day of testing
        //12AM = Time
        String CurTime = Time.substring(0,Time.length()-2);
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
        if(Integer.parseInt(CurTime)<0) {


            if (Time == "-2") {//idealy this would be for using the actual time
                Date curTime = new Date();
                System.out.println(curTime.getTime());
            }
            if (Time == "-1") {//since you selected -1 A random timeslot will be selected
                int timeSlot = (int) (Math.random() * 7);
                int TimeAmt = curDay[timeSlot];
                Random Rand = new Random();
                System.out.println("the day selected is " + Day.toUpperCase() + " and the time chosen was " + timeSlot + " with the normal amount of people being " + TimeAmt);
                return (int) (Rand.nextGaussian() * 5) + TimeAmt;


            }
            //this is when they input
        }else {
            int realTime = Integer.parseInt(CurTime);
            if(realTime >9 && realTime<12 && Time.contains("AM")|| (realTime%12 >= 0 && realTime%12 <5) &&Time.contains("PM")) {
                int TimeSlot = Integer.parseInt(CurTime);
                if(TimeSlot<10){
                    TimeSlot = TimeSlot +12;
                }
                //now times are in military time so its going to be 10 11 12 13 14 15 16
                int index = TimeSlot-10;
                int TimeAmt = curDay[index];
                Random Rand = new Random();
                System.out.println("the day selected is " + Day.toUpperCase() + " and the time chosen was " + Time + " with the normal amount of people being " + TimeAmt);
                return (int) (Rand.nextGaussian() * 5) + TimeAmt;
            }
        }

        return -1;
    }

    public int GetWaitTime(){
        int Stage1SecondsPerPerson= 73;// the amount of time it takes to get your vial and register your name
        Random Rand = new Random();
        Stage1SecondsPerPerson = (int) (Rand.nextGaussian()*10)+ Stage1SecondsPerPerson;
        return(Stage1SecondsPerPerson);

    }

}
