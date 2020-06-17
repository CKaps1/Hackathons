//Integrated File System
//Christian Kapsales
//Purpose: To store data of multiple contestants enrolled in different contests.

import java.io.*;
import java.nio.file.Files;
import java.util.*;
public class FileSystem {
static StringTokenizer st;
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//might replace sc with readLine function
	public static void main(String[] args)throws IOException, InterruptedException {
		//run help/instructions method
		help();
		//create file
		 try {
		      File myObj = new File("fileSystem.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        //convert to binary
//		    	byte[] fileData = new byte[(int) myObj.length()];
//				FileInputStream in = new FileInputStream(myObj);
//				in.read(fileData); 
//				in.close();
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		out.close();
	}
	
static void addContestant() throws IOException {
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
	
	
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Integer> map = new HashMap<>();
	
	String[] Districts = {"Algoma", "Avon", "Bluewater", "Niagara", "Durham", "Erie", "Halton", "Hamilton", "Hastings", "Toronto", "Simco",
			"Hamilton", "Waterloo", "Upper Canada"};
	
	//create conditions for these
	System.out.println("What is your first name? ");
	String firstName = sc.nextLine();
	System.out.println("What is your last name? ");
	String lastName = sc.nextLine();
	System.out.println("Confirm your first name: ");
	String firstConfirm = sc.nextLine();
	System.out.println("Confirm your last name: ");
	String lastConfirm = sc.nextLine();
	
	//verify first and last names
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
		//make the first and last name have capital first letters
	  firstName = firstName.toLowerCase();
	  lastName = lastName.toLowerCase();
	  firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
	  lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
	  
	
	System.out.println("What is your email address? ");
	String email = sc.nextLine();
	
	//verify that email address is legitimate
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


	//Ask and verify for school district
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
					System.out.println("The score has to inbetween 0 and 100 inclusively");
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

	
}

static void removeContestant() throws IOException {
	System.out.println("what is the ID or last name of the contestant that you want to be removed? ");
	String match = readLine();
	BufferedReader reader = new BufferedReader(new FileReader("fileSystem.txt"));
	String line = reader.readLine();
    while (line != null) {
    	if (line == match ) {
//    		List<String> lines = Files.readAllLines(fileSystem.toPath());
//    		lines.set(line, dataType.toUpperCase() + ":" + newData);
//    		Files.write(fileSystem.toPath(), lines);
    	}
        line = reader.readLine();
    }
    System.out.println("Your contestant does not exist");
}
static void searchContestant() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("fileSystem.txt"));
    String find = readLine();
    String line = reader.readLine();
    while (line != null) {
        if (line == find) {
            break;
        }
        line = reader.readLine();
    }
    System.out.println("Your contestant doesn't exist");
}
static void displayContestants() throws IOException {
	Scanner in = new Scanner(System.in);
    String comp = in.nextLine();
    String name = null, N1, N2, N3;
    int S1, S2, S3, score;
    BufferedReader reader = new BufferedReader(new FileReader("FileSystem.txt"));
    String line = reader.readLine();
    name += line;
    while (line != null) {
        line = reader.readLine();
        name += " " + line;
        line = reader.readLine();
        line = reader.readLine();
        System.out.println(name);
        line = reader.readLine();
        line = reader.readLine();
        if (line == comp) {
            line = reader.readLine(); // score
            score = Integer.parseInt(line);
        }
        else {
            line = reader.readLine(); // score
        }
        line = reader.readLine(); // go again with first name
        name = line;
    }
}
static void displayTop() throws IOException {
	ArrayList<Integer> top = new ArrayList<>();
	HashMap<Integer, String> hm = new HashMap<>();
	Scanner in = new Scanner(System.in);
    String comp = in.nextLine();
    String name = null, N1, N2, N3;
    int S1, S2, S3, score;
    BufferedReader reader = new BufferedReader(new FileReader("FileSystem.txt"));
    String line = reader.readLine();
    name += line;
    while (line != null && top.size() < 3) {
        line = reader.readLine();
        name += " " + line;
        line = reader.readLine();
        line = reader.readLine();
        name += " " + line;
        line = reader.readLine();
        line = reader.readLine();
        if (line == comp) {
            line = reader.readLine(); // score
            score = Integer.parseInt(line);
            // compare score and keep N1, N2, N3, S1, S2, S3
            top.add(score);
            hm.put(score,name);
        }
        else {
            line = reader.readLine(); // score
        }
        line = reader.readLine(); // go again with first name
        name = line;
    }
    Collections.sort(top);
    System.out.println("The Top 3 Contestants for " + comp + " contest is: ");
    for (double i : top) {
    	System.out.println(hm.get(i) + " with a score of " + i);
    }
}

static void help() throws InterruptedException, IOException {
	//create help manual
	//format nicely
	// TODO: run help function at the beginning of program - and have the option to call it using a given input from user
	int option = 0;
	while (option != 9) {
	System.out.println("Welcome to Christian's integrated storage file system!");
	Thread.sleep(500);
	System.out.println("For help with adding a contestant to the database, enter 1");
	Thread.sleep(500);
	System.out.println("For help with removing a contestant to the database, enter 2");
	Thread.sleep(500);
	System.out.println("To search for a contestant, enter 3");
	Thread.sleep(500);
	System.out.println("To display the contestants in order, enter 4");
	Thread.sleep(500);
	System.out.println("To display the top 3 contestants, enter 5");
	Thread.sleep(500);
	System.out.println("To access this help menu again, enter 0");
	Thread.sleep(500);
	System.out.println("To exit this menu, enter 9");
	//put try and catch here
	try {
		option = readInt();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (option == 9) {return;}
	if (option == 1) {System.out.println("To add a contestant to the database, you must input the following queries. If you want to add a contestant enter 1 again: "); int option2 = readInt();
		if (option2 == 1) addContestant();
	}
	if (option == 2) {System.out.println("To remove a contestant from the database, you must first give ID or last name of the contestant. If you want to remove a contestant, enter 2 again: ");  int option2 = readInt();
		if (option2 == 2) removeContestant();
	}
	if (option == 3) {System.out.println("To search for a contestant , enter their last name, birthdate or school district. If you want to search for a contestant, enter 3 again: ");  int option2 = readInt();
		if (option2 == 3) searchContestant();
	}
	if (option == 4) {System.out.println("This option will display the contestants by order of their last name. If you want to display the contestants in order of surname, enter 4: ");  int option2 = readInt();
	if (option2 == 4) displayContestants();
	}
	if (option == 5) {System.out.println("This displays the top 3 contestants for a given contest based on score. If you want to display the top 3 contestants for a given contest, enter 5: ");  int option2 = readInt();
	if (option2 == 5) displayTop();
	}
	if (option == 0) {System.out.println();}
	}
}

// Fast IO methods
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