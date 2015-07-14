

public class ZDigit {
	private char c;

	public ZDigit(char c) {
		int b = c;
		if ((b>=65 && b<=90) || c == '0')
			this.c = c;

		else
			throw new IllegalArgumentException("Please enter Capital letters from English alphabet only");
	}
	public char getChar() {
		return c;
	}
}