import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise670 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int count = 0;
		Set<Integer> setOfNumerals = new HashSet<Integer>();
		int numberOfNumerals = 0; // count of digits in number
		int sequenceMember = 0; // current number
		int remainder = 0;

		while (number != count) {
			sequenceMember++;
			int copy = sequenceMember;
			while (copy != 0) {
				remainder = copy % 10;
				copy /= 10;
				setOfNumerals.add(remainder);
				numberOfNumerals++;
			}

			if (setOfNumerals.size() == numberOfNumerals) { // hashset doesn't
															// include the same
															// elements
				count++;
			}
			numberOfNumerals = 0;
			setOfNumerals.clear();
		}
		System.out.println(sequenceMember);
		in.close();
	}
}