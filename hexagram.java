Jake Weber
1/28/24

// Backtracking implementation to efficiently compute the solution of a problem with 12! cases

// Given a hexagram with 12 points, find distinct points that can be filled in to satisfy the magic
// sum. The magic sum is the number that every line in the hexagram must add to. The hexagram will
// look something like this:

/*
		       0
	       0    0	 0    0
		  0	   0
	       0     0	 0   0
		       0
*/
	
import java.util.Scanner;

public class hexagram {
	
	public static int magicNum;
	public static int numOfWays;
	public static int[] puzzle = new int[12];
	
	public static void main (String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		while (true) {
			
			magicNum = 0;
			numOfWays = 0;
			
			// User input
			for (int i = 0; i < 12; i++) {
				puzzle[i] = stdin.nextInt();
				magicNum += puzzle[i];
			}
			
			// End program
			if (magicNum == 0)
				break;
			
			// Input has 0 numOfWays
			if (magicNum % 3 != 0) {
				System.out.println(0);
				continue;
			}
			
			// Declare other variables here.
			magicNum /= 3;
			int[] verticies = new int[12];
			for (int i = 0; i < 12; i++)
				verticies[i] = 0;
			
			// Process information.
			fill(verticies, 0);
			numOfWays /= 12;
			System.out.println(numOfWays);
			
		}
		
	}
	
	// Permute fill
	public static void fill (int[] verticies, int k) {
		
		/*
		Hexagram verticies
			  4
		0	1	2	3
		  11	 5
		10	9	7	6
			  6
		*/
		
		// Check if verticies add up to magicNum
		switch (k) {
			case 4:
				if (verticies[0] + verticies[1] + verticies[2] + verticies[3] != magicNum)
					return;
				break;
			case 7:
				if (verticies[4] + verticies[2] + verticies[5] + verticies[6] != magicNum)
					return;
				break;
			case 9:
				if (verticies[3] + verticies[5] + verticies[7] + verticies[8] != magicNum)
					return;
				break;
			case 11:
				if (verticies[6] + verticies[7] + verticies[9] + verticies[10] != magicNum)
					return;
				break;
			case 12:
				if (verticies[8] + verticies[9] + verticies[11] + verticies[0] == magicNum)
					if (verticies[10] + verticies[11] + verticies[1] + verticies[4] == magicNum)
						numOfWays++;
				return;
			default:
				break;
		}
		
		for (int i = 0; i < 12; i++) {
			
			// Check if number already used
			boolean flag = false;
			for (int j = 0; j < k; j++) {
				if (verticies[j] == puzzle[i]) {
					flag = true;
					break;
				}
			}
			if (flag)
				continue;
			
			// Usual permutation code...
			verticies[k] = puzzle[i];
			fill(verticies, k + 1);
			verticies[k] = 0;
		}
		return;
	}	
}
