import java.util.Random;

public class MainGui {
    public void run(){
        int[] monday = {30, 18, 55, 43, 10, 32, 20};
        int[] Wednesday = {40,33,65,42,35,45,15};
        NumberGenerator NG = new NumberGenerator(monday, Wednesday);
        int numOfPeople = NG.GetSemiRandomWaitTime("Monday",-1);//test to run the method getSemi
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
       main.run();

    }
}
