import java.util.Scanner;

public class Exercise278 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String firstDNK = in.next();
		String secondDNK = in.next();

		char[] charsOfFirstDNK = firstDNK.toCharArray();
		char[] charsOfSecondDNK = secondDNK.toCharArray();
		int j = 0;
		int count = 0;
		for (int i = 0; i < charsOfFirstDNK.length; i++) {
			boolean detected = false;
			for (; j < charsOfSecondDNK.length; j++) {
				if (charsOfFirstDNK[i] == charsOfSecondDNK[j]) {
					count++;
					j++; // continue searching at next char
					detected = true;
					break;
				}
			}
			if (!detected || (detected && j == charsOfSecondDNK.length))
				break;
		}
		if (count == charsOfFirstDNK.length)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}