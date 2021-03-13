import java.util.HashMap;
// checks to see if the QUID exists, if it does results are returned
// if QUID doesn't exist in the HashMap, random test results are generated and then stored
public class CheckResults {

	public CheckResults() {
	}

	public String getResults(String QUID) {
		HashMap <String, String> testResults = new HashMap <String, String>();
		if (testResults.containsKey(QUID)) {
			return "Your test results are "+testResults.get(QUID)+".";
		}
		else {
			int max = 2;
			int min = 1;
			int randNum = (int) (Math.random()*(max-min+1)+min);
			if (randNum == 1) {
				testResults.put(QUID,"negative");
				return "Your test results are negative.";
			}

			else {
				testResults.put(QUID,"positive");
				return "Your test results are positive.";
			}
		}



	}
}
