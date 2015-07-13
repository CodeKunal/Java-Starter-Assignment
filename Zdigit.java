import java.util.Scanner;
public class Zdigit {
	private char c;
	public Zdigit(char c) {
		int b = c;
		if ((b>=65 && b<=90) || c == '0')
			this.c = c;

		else
			throw new IllegalArgumentException("Please enter Capital letters from English alphabet only or 0A");
	}

	public static void main(String[] args) {
		System.out.println("Enter any capital letter or 0  ");
		Scanner digit = new Scanner(System.in);
		char c = digit.next().charAt(0);
		Zdigit z = new Zdigit(c);

	}
	}
