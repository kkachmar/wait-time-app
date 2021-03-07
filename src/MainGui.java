import java.util.Random;

public class MainGui {
    public void run(){
        int[] monday = {30, 18, 55, 43, 10, 32, 20};
        int[] Wednesday = {40,33,65,42,35,45,15};
        NumberGenerator NG = new NumberGenerator(monday, Wednesday);
        int numOfPeople = NG.GetSemiRandomWaitTime("Monday",-1);//test to run the method getSemi
        System.out.println("The amount of people is " + numOfPeople);

    }

    public static void main(String[] args){
       MainGui main = new MainGui();
       main.run();

    }
}
