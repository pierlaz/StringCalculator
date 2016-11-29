package it.uniba.tdd;

public class StringCalculator {

	public static int add(String numbersStr) throws StringCalculatorException {
		final String startWithDelimiters = "//";
		final String newLine = "\\n";
		String[] delimiter = new String[1];

		String defaultDelimiter = ",|\\n";

		if (numbersStr == "") {
			return 0;
		}
		if (numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/') {
			delimiter = numbersStr.split(startWithDelimiters + "|" + newLine);
			if (delimiter[1].contains("[") && delimiter[1].contains("]")) {
				delimiter[1] = delimiter[1].substring(1, delimiter[1].length() - 1);
				String[] delims = delimiter[1].split("\\]\\[");
				String s = "";
				for (int i=0; i<delims.length; i++) {
					s += delims[i] + '|';
				}
				delimiter[1] = s;
				delimiter[1] = delimiter[1].substring(0, delimiter[1].length()-1);
			}
			defaultDelimiter = delimiter[1];
			if (defaultDelimiter.contains("-")) {
				char[] temp = numbersStr.toCharArray();
				for (int i = 0; i < numbersStr.length() - 1; i++) {
					if (temp[i] == '-' && '-' == temp[i + 1]) {
						throw new StringCalculatorException();
					}
				}
			}
			String[] tempo = numbersStr.split(newLine);
			numbersStr = tempo[1];
		}

		int sum = 0;

		String[] parts = numbersStr.split(defaultDelimiter);

		for (String string : parts) {
			if (Integer.parseInt(string) >= 0 && Integer.parseInt(string) <= 1000) {
				sum += Integer.parseInt(string);
			} else if (Integer.parseInt(string) < 0) {
				throw new StringCalculatorException();
			}
		}

		return sum;
	}

}