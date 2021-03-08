import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentRecordCreator {

    public ArrayList<String> QUIDs = new ArrayList<String>();
    public static String[] FirstNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "Kevin", "Brian", "George", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Jonathan", "Stephen", "Larry", "Justin", "Scott", "Brandon", "Benjamin", "Samuel", "Frank", "Gregory", "Raymond", "Alexander", "Patrick", "Jack", "Dennis", "Jerry", "Tyler", "Aaron", "Jose", "Henry", "Adam", "Douglas", "Nathan", "Peter", "Zachary", "Kyle", "Walter", "Harold", "Jeremy", "Ethan", "Carl", "Keith", "Roger", "Gerald", "Christian", "Terry", "Sean", "Arthur", "Austin", "Noah", "Lawrence", "Jesse", "Joe", "Bryan", "Billy", "Jordan", "Albert", "Dylan", "Bruce", "Willie", "Gabriel", "Alan", "Juan", "Logan", "Wayne", "Ralph", "Roy", "Eugene", "Randy", "Vincent", "Russell", "Louis", "Philip", "Bobby", "Johnny", "Bradley"};
    public static String[] LastName = {"Smith","Sullivan", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzales", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson", "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker", "Cruz", "Edwards", "Collins", "Reyes", "Stewart", "Morris", "Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan", "Cooper", "Peterson", "Bailey", "Reed", "Kelly", "Howard", "Ramos", "Kim", "Cox", "Ward", "Richardson", "Watson", "Brooks", "Chavez", "Wood", "James", "Bennet", "Gray", "Mendoza", "Ruiz", "Hughes", "Price", "Alvarez", "Castillo", "Sanders", "Patel", "Myers", "Long", "Ross", "Foster", "Jimenez"};



    public StudentRecordCreator() throws IOException {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        File Records = new File("../StudentRecords"+date+".txt");
        FileWriter writer = new FileWriter(Records);
        //time is from 10am to 5pm
        //
        String TimeHR = "";
        int HRHolder = 0;
        int MINHolder = 0;
        String TimeMIN = "";
        String Time ="";
        for(int i =0;i< 2000;i++){

            HRHolder = ((int)(Math.random()*7)+10);//giving values of 10 to 17
            HRHolder = HRHolder%12;
            if(HRHolder == 0){
                HRHolder = 12;
            }
            DecimalFormat myFormatter = new DecimalFormat("00");
            TimeHR = myFormatter.format(HRHolder);

            //now the range is 10 through 12 and 1 through 4
            MINHolder = (int)(Math.random()*60);

            TimeMIN = myFormatter.format(MINHolder);
            Time = TimeHR +":"+TimeMIN;
            writer.write("["+Time+"] "+this.RandomNameGenerator()+ " "+CreateQUID() + "\n");

        }
        writer.close();

    }
    public String CreateQUID(){
        String id = "";
        boolean flag = false;
        while(flag== false) {
            id = "";
            for (int i = 0; i < 7; i++) {
                id += (int) (Math.random() * 9);
            }
            if(QUIDs.contains(id)){
                flag = false;
            }
            else{
                flag = true;
            }
        }
        QUIDs.add(id);
        return id;

    }
    public static String RandomNameGenerator(){
        int firstNum = (int)(Math.random()*FirstNames.length);
        int LastNum = (int)(Math.random()*LastName.length);
        String Name = FirstNames[firstNum] + " " + LastName[LastNum];
        return Name;
    }

    public static void main(String[] args) throws IOException {
        StudentRecordCreator RC = new StudentRecordCreator();

    }
}
