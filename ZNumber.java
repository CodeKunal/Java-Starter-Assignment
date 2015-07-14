
final public class ZNumber {
	final public ZDigit array[];

	public ZNumber(char... cs) {
		array = new ZDigit[cs.length];
		int i;
		for (i = 0; i < cs.length; i++)
		array[i] = new ZDigit(cs[i]);
	}

	public ZNumber(String cs) {
		array = new ZDigit[cs.length()];
		int i;
		for (i = 0; i < cs.length(); i++)
		array[i] = new ZDigit(cs.charAt(i));
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (ZDigit z : array)
			sb.append(z.getChar());
		return sb.toString();
	}

	public long toDecimal() {
		long r = 0;
		for (int l = array.length - 1; l >= 0; l--) {
			r += (Math.pow(27, array.length - 1 - l)) * (array[l].getChar() == '0' ? 0 : (int) array[l].getChar() - 64);
		}
		return r;
	}

	public ZDigit[] getDigits() {
		return array;
	}

	public static void main(String[] args) {

		ZNumber num1 = new ZNumber("ABC");
		ZNumber num2 = new ZNumber('A','B','C','D');
		ZNumber num3 = new ZNumber(new char[] { 'A', 'B', 'C', 'D' });
		System.out.print("For the string " + num1);
		System.out.println(" the conversion into number is " + num1.toDecimal()+ ".");
		System.out.print("For the string " + num2);
		System.out.println(" the conversion into number is " + num2.toDecimal()+ ".");
		System.out.print("For the string " + num3);
		System.out.println(" the conversion into number is " + num3.toDecimal()+ ".");

	}
}