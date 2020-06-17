//Integrated File System
//Christian Kapsales
//Purpose: lol idek kid
//reprompt when there is error
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
		
		
		System.out.println("What is your email address? ");
		String email = sc.nextLine();
		
		//check if valid - make into seperate function
	boolean flag2 = true;
	while (flag2) {
		int position1 = email.indexOf('@');
		int position2 = email.lastIndexOf('.');
		if (position1 != -1 && position2 > position1 && email.lastIndexOf('@') == email.indexOf('@')) {flag2 = false; break;}
		else {
			System.out.println("Email is not valid, please try again: ");
			email = sc.nextLine();
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
				System.out.println("school district not found, please try again: ");
				schoolDistrict = sc.nextLine();
				test = Arrays.asList(Districts).contains(schoolDistrict);
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