import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentRecordReader {
    int AM10;
    int AM11;
    int PM12;
    int PM01;
    int PM02;
    int PM03;
    int PM04;
    int[] TimeRecords;
    String Day;

    public StudentRecordReader(String DOW) throws FileNotFoundException {
        //what i could do is create an array instead so that i could traverse this easier
         AM10 = 0;
         AM11 = 0;
         PM12 = 0;
         PM01 = 0;
         PM02 = 0;
         PM03 = 0;
         PM04 = 0;
        TimeRecords = new int[]{AM10, AM11, PM12, PM01, PM02, PM03, PM04};
        Day= DOW;
        this.run(Day);

    }
    public void run(String DOW ) throws FileNotFoundException {//DOW Day of week
        DOW = DOW.toUpperCase();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        File Records = new File("../StudentRecords"+date+"-"+DOW+".txt");
        Scanner in;
        in = new Scanner(Records);
        //what the input should read: [time]: FName LName QUID
        //This will be put into the system when a student taps card when getting tested
        int count = 0;
        String Line;
        while(in.hasNextLine() && (Line = in.nextLine()) != ""){
            String Time = Line.split(":")[0];
            //now this should have [hr as the string
            Time = Time.substring(1);
            int hour = Integer.parseInt(Time);
            switch (hour){
                case 10:
                    AM10++;
                    break;
                case 11:
                    AM11++;
                    break;
                case 12:
                    PM12++;
                    break;
                case 01:
                    PM01++;
                    break;
                case 02:
                    PM02++;
                    break;
                case 03:
                    PM03++;
                    break;
                case 04:
                    PM04++;
                    break;
            }
            String name = Line.split(" ")[1] + " "+ Line.split(" ")[2];
            String QUIDNum = Line.split(" ")[3];


        }
         TimeRecords = new int[] {AM10,AM11,PM12,PM01,PM02,PM03,PM04};
        String[] Times = {"10","11","12","01","02","03","04"};
        int counterz = 0;
        /**
         * used for debug
        System.out.println("Hour Total");
        for(int i :TimeRecords){
            System.out.print(Times[counterz]+"   ");
            System.out.println(i);
            counterz++;
        }
         **/
    }
    public int[] ValsOfTimes(){//can only be ran after insisializing day aka running run
        return TimeRecords;
    }

    /**
     * only used for testing the class works
    public static void main(String[] args) throws FileNotFoundException {
        StudentRecordReader RR = new StudentRecordReader();
        RR.run("Monday");
    }
     **/
}
