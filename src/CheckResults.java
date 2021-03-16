import java.util.HashMap;
// checks to see if the QUID exists, if it does results are returned
// if QUID doesn't exist in the HashMap, random test results are generated and then stored
public class CheckResults {
	public int activeCases;
	public HashMap <String, String> testResults = new HashMap <String, String>();  

	public CheckResults() {
		activeCases = 5;
		testResults = new HashMap <String, String>();
	}
	public CheckResults(int activecases, HashMap results) {
		activeCases = activecases;
		testResults = results;
	}


	public String getResults(String QUID) {
		
		if (testResults.containsKey(QUID)) {
			if (testResults.get(QUID).equals("positive")) {
			}
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
				activeCases++;
				return "Your test results are positive.";
			}
		}



	}
	public HashMap getHash() {
		return (this.testResults);
	}
	public void SetHash(HashMap hash){
		this.testResults = hash;
	}
}
