import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

	public static boolean isSafe(int board[][], int row, int col, int value) {
		int i, j;

		for (j = 0; j < 9; j++) {
			if (board[row][j] == value)
				return false;
		}
		for (i = 0; i < 9; i++) {
			if (board[i][col] == value)
				return false;
		}
		int a = 3 * (row / 3);
		int b = 3 * (col / 3);
		for (i = a; i < a + 3; i++) {
			for (j = b; j < b + 3; j++) {
				if (board[i][j] == value)
					return false;
			}
		}
		return true;
	}

	public static boolean solveSudokuUtil(int board[][], int row, int col) {
		if (row >= 9 && col == 0)
			return true;

		if (board[row][col] == 0) {
			for (int m = 1; m <= 9; m++) {
				if (isSafe(board, row, col, m) == true) {
					board[row][col] = m;
					boolean temp;
					if (col == 8)
						temp = solveSudokuUtil(board, row + 1, 0);
					else
						temp = solveSudokuUtil(board, row, col + 1);
					if (temp)
						return true;
				}
			}
			board[row][col] = 0;
			return false;
		} else {
			if (col == 8)
				return solveSudokuUtil(board, row + 1, 0);
			else
				return solveSudokuUtil(board, row, col + 1);
		}

	}

	public static void printSolution(int board[][]) {
		for (int m = 0; m < 9; m++) {
			for (int n = 0; n < 9; n++) {
				System.out.print((board[m][n]) + " ");
			}
			System.out.println(" ");
		}
	}

	public static boolean solveSudoku() {

		int[][] board = new int[9][9];
		if (solveSudokuUtil(board, 0, 0) == false) {
			System.out.println("U have entered wrong Sudoku");
			return false;
		}
		printSolution(board);
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("p096_sudoku.txt"));
		int i = 0, p = 0, g=0;
		int[][] array = new int[9][9];
		while (scan.hasNextLine()) {
			int j = 0;
			String str = scan.nextLine();
			if (p % 10 != 0) {
			
				while (j < str.length()) {
					array[i][j] = str.charAt(j) - 48;
					j++;
				}
				i++;
			}
			
			p++;

			if (i == 9) {g++;
				i = 0;
				System.out.printf("Unsolved Grid:%d \n\n",g); 
				for(int z=0;z<9;z++){
					 for(int y=0;y<9;y++){
					 System.out.print(array[z][y]+ " ");
					 }
					 System.out.println();
					 }
				System.out.printf("\n\nSolved Grid:%d  \n\n",g);
			solveSudoku();
		}
		}
}
}