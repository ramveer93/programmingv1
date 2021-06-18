package wissen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWordsInString {

	public static void main(String[] args) {
		String s = "Hey how you doongin    it  is    england";
		// new CountWordsInString().printWords(s);
		new CountWordsInString().byRegex(s);

	}

	public void printWords(String s) {
		if (s == null || s.isEmpty())
			return;
		String[] w = s.split("\\s+");
		for (String str : w)
			System.out.println(str);

	}

	public void byRegex(String s) {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
