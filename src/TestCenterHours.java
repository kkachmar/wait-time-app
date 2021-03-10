// determines whether or not the testing center is open
// if center is closed, tells user when it will be open next

// expected input is lower case day of week and integer representing the hour
public class TestCenterHours {
	
	public TestCenterHours() {
		
	}
	public String isOpen(String day, int hour) {
		if ((day.equals("monday")||day.equals("wednesday"))&&(hour>=10&&hour<=4)) 
			return "We're open!";
		
		else if (day.equals("tuesday")||(day.equals("monday")&&hour>4)||(day.equals("wednesday")&&hour<10)) 
			return "Sorry we're closed. We'll be open Wednesday at 10 AM";
		
		else 
			return "Sorry we're closed. We'll be open Monday at 10 AM";
		
	}
}

