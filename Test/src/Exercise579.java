import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise579 {

	public static void main(String[] args) {

		int sumPositive = 0;
		int sumNegative = 0;
		int countNegative = 0;
		int countPositive = 0;

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int sizeOfSequence = 0;
		try {
			sizeOfSequence = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String scString = in.nextLine();
		StringBuffer positionOfPositiveElements = new StringBuffer(sizeOfSequence);
		StringBuffer positionOfNegativeElements = new StringBuffer(sizeOfSequence);
		String[] scStrings = scString.split(" ");
		int number = 0;

		for (int i = 0; i < sizeOfSequence; i++) {

			number = Integer.valueOf(scStrings[i]);

			if (number < 0) {
				sumNegative += number;
				countNegative++;
				number = i + 1;
				positionOfNegativeElements.append(number).append(" ");

			} else if (number > 0) {
				sumPositive += number;
				countPositive++;
				number = i + 1;
				positionOfPositiveElements.append(number).append(" ");

			}
		}
		sumNegative *= -1;
		if (sumPositive > sumNegative) {
			out.println(countPositive);
			out.println(positionOfPositiveElements);
		} else {
			out.println(countNegative);
			out.println(positionOfNegativeElements);

		}
		out.flush();
		in.close();
	}
}