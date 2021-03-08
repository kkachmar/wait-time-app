import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentRecordReader {

    public StudentRecordReader(){
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
        while((Line = in.nextLine()) != ""){
            System.out.println(Line +" "+ count++);

        }



    }

    public static void main(String[] args) throws FileNotFoundException {
        StudentRecordReader RR = new StudentRecordReader();
        RR.run();
    }
}
