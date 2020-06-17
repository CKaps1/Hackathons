//Integrated File System
//Christian Kapsales
//Purpose: lol idek kid
//reprompt when there is error
//replace scanner with buffer functions
import java.io.*;
import java.util.*;
public class FileSystem {
static StringTokenizer st;
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//might replace sc with readLine function
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		File file = new File("StudentData");
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
		
		boolean flag1 = true;
		while(flag1) {
			if (firstName.equals(firstConfirm) && lastName.equals(lastConfirm)) break;
			else {
			//first name confirmed, last name not
			if (firstName.equals(firstConfirm) && !lastName.equals(lastConfirm)) {
				System.out.println("reconfirm last name");
				lastConfirm = sc.nextLine();
			}
			//last name confirmed, first name not
			if (!firstName.equals(firstConfirm) && lastName.equals(lastConfirm)) {
				System.out.println("reconfirm first name");
				firstConfirm = sc.nextLine();
			}
			if (!firstName.equals(firstConfirm) && !lastName.equals(lastConfirm)) {
				System.out.println("reconfirm first and last name");
				firstConfirm = sc.nextLine();
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
		//if  i have time put months of each day and check accordingly, for now assume 31 days
		String format;
		String monthFormat;
		System.out.println("What year are you born in? ");
		int year = readInt();
		while(true) {
			if (year >=1000 && year <= 9999) break;
			else {
				System.out.println("Has to be a valid year of the format - yyyy, please try again: ");
				year = readInt();
			}
		}
		System.out.println("What month are you born in? ");
		int month = readInt();
		while(true) {
			if (month >= 1 && month <= 12) break;
			else {
				System.out.println("Has to be a valid month from 1-12, please try again: ");
				month = readInt();
			}
		}
		//add zero if 1-9
		if (month >=1 && month <= 9) {monthFormat =  "0" +  month;}
		else monthFormat = "" + month;
		
		System.out.println("What day of the month are you born in? ");
		int day = readInt();
		while(true) {
			if (day >= 1 && day <= 31) break;
			else {
				System.out.println("Has to be a valid day from 1-31, please try again: ");
				day = readInt();
			}
		}
		format = day + "/" + monthFormat + "/" + year;
		//assume any competition and ask in slack
		System.out.println("What competition are you competing in? ");
		String competition = readLine();
		System.out.println("What is the score you recieved? ");
		double score = readDouble();
		while(true) {
			if (score >=0 && score <= 100) break;
			else {
				System.out.println("The score has to inbetween 0 and 100 inclusively");
				score = readDouble();
			}
		}
		
		out.close();
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