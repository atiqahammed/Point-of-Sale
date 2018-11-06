package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	public boolean checkString(String name) {
		String line = name;
		String pattern = "^[^\\s]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test = new Test();
		if(test.checkString("  ")){
			System.out.println("find");
		}
		else
			System.out.println("lose");

	}

}
