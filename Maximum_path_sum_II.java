import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Maximum_path_sum_II {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("/home/zemoso013/workspace4/Euler_Project/src/p067_triangle.txt"));
		int[][] triangle = new int[100][];
		int i = 0, j = 0;
		while (scan.hasNextLine()) {
			String str = scan.nextLine();
			String[] t = str.split(" ");
			triangle[i] = new int[t.length];
			for (j = 0; j < t.length; j++) {
				triangle[i][j] = Integer.parseInt(t[j]);
			}
			i++;
		}

		for (int m = 98; m >= 0; m--) {
			for (int n = 0; n < triangle[m].length; n++) {

				triangle[m][n] += Math.max(triangle[m + 1][n], triangle[m + 1][n + 1]);
			}
		}
		System.out.println("Max path sum is: " + triangle[0][0]);
	}
}
