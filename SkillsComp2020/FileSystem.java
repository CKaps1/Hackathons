//Integrated File System
//Christian Kapsales
//Purpose: lol idek kid
//reprompt when there is error
//replace scanner with buffer functions
//create one file per contestant
//create functions for each functionality and form of input
//anywhere try and accept
//create java docs
//mulptile files for each contestant means remove contestant == remove file
import java.io.*;
import java.util.*;
public class FileSystem {
static StringTokenizer st;
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//might replace sc with readLine function
	public static void main(String[] args)throws IOException {
		//run help/instructions method
		help();
		Scanner sc = new Scanner(System.in);
		try {
			File ids = new File("IDs.txt");
			if (ids.createNewFile()) {
				  System.out.println("File created: " + ids.getName());
			}
			else {
				System.out.println("IDs file already exists.");
			}
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		//text file generator -> binary
		//put at the end of add contestant method
		try {
		      File myObj = new File("filename.txt");
		      if (myObj.createNewFile()) {
				  System.out.println("File created: " + myObj.getName());
				  //convert to binary
				  byte[] fileData = new byte[(int) myObj.length()];
				  FileInputStream in = new FileInputStream(myObj);
				  in.read(fileData); 
				  in.close();
		      } 
		      else {
		    	  System.out.println("File already exists.");
		      }
		    } 
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
		    }
		
		String[] Districts = {"Algoma", "Avon", "Bluewater", "Niagara", "Durham", "Erie", "Halton", "Hamilton", "Hastings", "Toronto", "Simco",
				"Hamilton", "Waterloo", "Upper Canada"};
		HashMap<Integer, Integer> map = new HashMap<>();
		
		//create conditions for these
		System.out.println("What is your first name? ");
		String firstName = sc.nextLine();
		System.out.println("What is your last name? ");
		String lastName = sc.nextLine();
		System.out.println("Confirm your first name: ");
		String firstConfirm = sc.nextLine();
		System.out.println("Confirm your last name: ");
		String lastConfirm = sc.nextLine();
		
		boolean flag1 = true;
		while(flag1) {
			if (firstName.equals(firstConfirm) && lastName.equals(lastConfirm)) break;
			else {
				//first name confirmed, last name not
				if (firstName.equals(firstConfirm) && !lastName.equals(lastConfirm)) {
					System.out.println("Reconfirm last name: ");
					lastConfirm = sc.nextLine();
				}
				//last name confirmed, first name not
				if (!firstName.equals(firstConfirm) && lastName.equals(lastConfirm)) {
					System.out.println("Reconfirm first name: ");
					firstConfirm = sc.nextLine();
				}
				if (!firstName.equals(firstConfirm) && !lastName.equals(lastConfirm)) {
					System.out.println("Reconfirm first name: ");
					firstConfirm = sc.nextLine();
					System.out.println("Reconfirm last name: ");
					lastConfirm = sc.nextLine();
				}
			}
		}
		//make first and last name capital first letter
		firstName = firstName.toLowerCase();
		lastName = lastName.toLowerCase();
		firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
		lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
		
		System.out.println("What is your email address? ");
		String email = sc.nextLine();
		
		//check if valid - make into seperate function
		//check for two consecutive period after @
		boolean flag2 = true;
		while (flag2) {
			int position1 = email.indexOf('@');
			int position2 = email.lastIndexOf('.');
			for (int i = position1 + 1; i < email.length(); i++) {
				if (email.charAt(i) == email.charAt(i-1) && email.charAt(i) == '.') {
					System.out.println("Email is not valid, please try again: ");
					email = sc.nextLine();
					break;
				}
			}
			if (!(position1 != -1 && position2 > position1 && email.lastIndexOf('@') == email.indexOf('@') && email.indexOf('@') != 0)){
				System.out.println("Email is not valid, please try again: ");
				email = sc.nextLine();
			}
			else {
				flag2 = false; break;
			}
		}
	
		//make into seperate function
		System.out.println("What is your school district? ");
		String schoolDistrict = sc.nextLine();
		boolean flag3 = true;
		//should be true
		boolean test = Arrays.asList(Districts).contains(schoolDistrict);
		
		while(flag3) {
			if(test) {flag3 = false; break;}
			else {
				System.out.println("School district not found, please try again: ");
				schoolDistrict = sc.nextLine();
				test = Arrays.asList(Districts).contains(schoolDistrict);
			}	
		}
		
		//Birthday
		//format data into string
		//if I have time put months of each day and check accordingly, for now assume 31 days
		String format;
		System.out.println("What year are you born in? ");
		int year;
		while (true) {
			try {
				year = readInt();
				while(true) {
					if (year >= 1000 && year <= 9999) break;
					else {
						System.out.println("Has to be a valid year of the format - yyyy, please try again: ");
						year = readInt();
					}
				}
				break;
			}
			catch(Exception NumberFormatException) {
				System.out.println("Year not valid, please try again: ");
			}
		}
		System.out.println("What month are you born in? ");
		int month;
		String monthFormat;
		while (true) {
			try {
				month = readInt();
				while(true) {
					if (month >= 1 && month <= 12) break;
					else {
						System.out.println("Has to be a valid month from 1-12, please try again: ");
						month = readInt();
					}
				}
				break;
			}
			catch(Exception NumberFormatException) {
				System.out.println("Month not valid, please try again: ");
			}
		}
		//add zero if 1-9
		if (month >= 1 && month <= 9) {monthFormat =  "0" +  month;}
		else monthFormat = "" + month;
		System.out.println("What day of the month are you born in? ");
		int day;
		day = readInt();
		while (true) {
			try {
				while(true) {
					if (day >= 1 && day <= 31) break;
					else {
						System.out.println("Has to be a valid day from 1-31, please try again: ");
						day = readInt();
					}
				}
				break;
			}
			catch(Exception NumberFormatException) {
				System.out.println("Day not valid, please try again: ");
			}
		}
		format = day + "/" + monthFormat + "/" + year;
		
		//assume any competition and ask in slack
		System.out.println("What competition are you competing in? ");
		String competition = readLine();
		System.out.println("What is the score you recieved? ");
		double score;
		while (true) {
			try {
				score = readDouble();
				break;
			}
			catch(Exception NumberFormatException) {
				System.out.println("Score not valid, please try again: ");
			}
		}
		while(true) {
			if (score >= 0 && score <= 100) break;
			else {
				System.out.println("The score has to in between 0 and 100 inclusively");
				score = readDouble();
			}
		}
		
		// Generate IDs with random 8 digit number + use hashmap to check for duplicates
		System.out.println("Assigning ID... ");
		BufferedReader reader = new BufferedReader(new FileReader("IDs.txt"));
		String line = reader.readLine();
		while (line != null) {
        	int val = Integer.parseInt(line);
        	map.put(val, 1);
            line = reader.readLine();
        }
		FileWriter writer = new FileWriter("IDs.txt");
		Random seed = new Random();
		int ID;
		int rand = seed.nextInt(10000000); // random value from 1 - (10000000 - 1)
		while (true) {
			if (rand < 1000000 || map.containsKey(rand)) {
				rand = seed.nextInt(10000000);
			}
			else {
				writer.write(Integer.toString(rand));
				writer.write(System.getProperty("line.separator"));
				ID = rand;
				break;
			}
		}
		reader.close();
		writer.close();
		System.out.println("Your assigned ID is " + ID);
		out.close();
	}
	
static void addContestant() {
	//put all input from main into here
	//wait for bobliu hashmap and trys and catches
	
	//DONE
}

static void removeContestant() {
	
	
	
}

static void searchContestant() {
	
	
	
}
static void displayContestants() {
	
	
	
}
static void displayTop() {
	
	
	
	
}
static void help() {
	//create help manual
	//format nicely
	// TODO: run help function at the beginning of program - and have the option to call it using a given input from user
	System.out.println("Welcome to Christian's integrated storage file system!");
	//use pause function from lib
	System.out.println("For help with adding a contestant to the database, enter 1");
	//use pause function from lib
	System.out.println("For help with removing a contestant to the database, enter 2");
	//use pause function from lib
	System.out.println("To search for a contestant, enter 3");
	//use pause function from lib
	System.out.println("To display the contestants in chronological order, enter 4");
	//use pause function from lib
	System.out.println("To display the top 3 contestants, enter 5");
	//use pause function from lib
	//IN order to access help menu again -- press "x"
	System.out.println("To access this help menu again, enter 0");
	
	//put try and catch here
	int option = 0;
	try {
		option = readInt();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if (option == 1) {}
	if (option == 2) {}
	if (option == 3) {}
	if (option == 4) {}
	if (option == 5) {}
	if (option == 0) {}
}
static String next () throws IOException {
	while (st == null || !st.hasMoreTokens())
	st = new StringTokenizer(br.readLine().trim());
	return st.nextToken();
	}
static long readLong () throws IOException {
	return Long.parseLong(next());
	}
static int readInt () throws IOException {
	return Integer.parseInt(next());
	}
static double readDouble () throws IOException {
	return Double.parseDouble(next());
	}
static char readCharacter () throws IOException {
	return next().charAt(0);
	}
static String readLine () throws IOException {
	return br.readLine().trim();
	}
}