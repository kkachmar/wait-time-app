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

    public StudentRecordReader(){
        //what i could do is create an array instead so that i could traverse this easier
        int AM10 = 0;
        int AM11 = 0;
        int PM12 = 0;
        int PM01 = 0;
        int PM02 = 0;
        int PM03 = 0;
        int PM04 = 0;

    }
    public void run() throws FileNotFoundException {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        File Records = new File("../StudentRecords"+date+".txt");
        Scanner in;
        in = new Scanner(Records);
        //System.err.println("No file found in the directory that you gave");
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

        }
        int[] TimeRecords = {AM10,AM11,PM12,PM01,PM02,PM03,PM04};
        String[] Times = {"10","11","12","01","02","03","04"};
        int counterz = 0;
        System.out.println("Hour Total");
        for(int i :TimeRecords){
            System.out.print(Times[counterz]+"   ");
            System.out.println(i);
            counterz++;
        }



    }

    public static void main(String[] args) throws FileNotFoundException {
        StudentRecordReader RR = new StudentRecordReader();
        RR.run();
    }
}
