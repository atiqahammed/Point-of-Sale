package regularX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REX {
	public boolean strEmptyTest(String name) {
		String line = name;
		String pattern = "^[^\\s]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return true;
		else
			return false;
	}

	public boolean checkName(String name) {
		String line = name;
		String pattern = "[A-Z][a-z]*";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return true;
		else {
			return false;
		}
	}

	public boolean checkPassword(String password) {

		String line = password;
		String pattern = "^[a-zA-Z0-9]{5,10}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return true;
		else {
			return false;

		}
	}

	public boolean checkPhoneNumber(String phoneNumber) {

		String line = phoneNumber;
		// String pattern = "(^[01]{2}[5-9]{1}[0-9]{8})$";

		String pattern = "(^[+88]*01[5-9]{1}[0-9]{8})$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return true;
		else {
			return false;

		}

	}

}
