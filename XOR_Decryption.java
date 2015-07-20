import java.util.Scanner;
import java.io.File;
import java.io.*;

public class XOR_Decryption {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("p060_cipher.txt"));
		int[] text;
		int j = 0;

		String str = scan.nextLine();
		String[] t = str.split(",");
		text = new int[t.length];
		for (j = 0; j < t.length; j++)
			text[j] = Integer.parseInt(t[j]);
		System.out.println("The no. of characters in p060_cipher.txt are: "+t.length);
		System.out.println();
		int p = 0, q = 0, r = 0;
		for (p = 97; p <= 122; p++) {
			int dc1, m;
			for (m = 0; m <= 1200; m += 3) {
				dc1 = text[m] ^ p;
				if (dc1 >= 32 && dc1 <= 34 || dc1 >= 39 && dc1 <= 41 || dc1 >= 44 && dc1 <= 46 || dc1 >= 48 && dc1 <= 59
						|| dc1 >= 63 && dc1 <= 90 || dc1 >= 97 && dc1 <= 122)
					continue;
				else
					break;
			}

			for (q = 97; q <= 122; q++) {
				int dc2, k;
				for (k = 1; k <= 1198; k += 3) {
					dc2 = text[k] ^ q;
					if (dc2 >= 32 && dc2 <= 34 || dc2 >= 39 && dc2 <= 41 || dc2 >= 44 && dc2 <= 46
							|| dc2 >= 48 && dc2 <= 59 || dc2 >= 63 && dc2 <= 90 || dc2 >= 97 && dc2 <= 122)
						continue;
					else
						break;
				}

				for (r = 97; r <= 122; r++) {
					int dc3, l;
					for (l = 2; l <= 1199; l += 3) {
						dc3 = text[l] ^ r;
						if (dc3 >= 32 && dc3 <= 34 || dc3 >= 39 && dc3 <= 41 || dc3 >= 44 && dc3 <= 46
								|| dc3 >= 48 && dc3 <= 59 || dc3 >= 63 && dc3 <= 90 || dc3 >= 97 && dc3 <= 122)
							continue;
						else
							break;
					}
					if (l > 1200)
						break;
				}
				if (k > 1200)
					break;
			}
			if (m > 1200)
				break;
		}
		System.out.println("The key1 is = " + p);
		System.out.println("The key2 is = " + q);
		System.out.println("The key3 is = " + r);
		char[] a = { (char) p };
		char[] b = { (char) q };
		char[] c = { (char) r };
System.out.print("The key is: ");
		System.out.print(a);
		System.out.print(b);
		System.out.println(c);
		int z = 0;
		int[] array = new int[1201];
		for (z = 0; z <= 1197; z += 3) {
			array[z] = text[z] ^ 103;
			array[z + 1] = text[z + 1] ^ 111;
			array[z + 2] = text[z + 2] ^ 100;
		}
		for (int i = 0; i <= 1200; i++) {
			System.out.print((char) array[i]);
		}
	}
}
