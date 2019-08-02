package PrepareLife;

import java.util.HashMap;

/**
 * Function Description
 * 
 * Complete the countingValleys function in the editor below. It must return an
 * integer that denotes the number of valleys Gary traversed.
 * 
 * countingValleys has the following parameter(s):
 * 
 * n: the number of steps Gary takes s: a string describing his path Input
 * Format
 * 
 * The first line contains an integer , the number of steps in Gary's hike. The
 * second line contains a single string , of characters that describe his path.
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print a single integer that denotes the number of valleys Gary walked through
 * during his hike.
 * 
 * Sample Input
 * 
 * 8 UDDDUDUU 
 * Sample Output
 * 1
 * 
 * @author JJI
 * 
 */
public class CountingValleys {

	public static void main(String[] args) {

		String s = "DDUUDDUDUUUD";
		System.out.println(countingValleys(s.length(), s));
	}

	// Complete the countingValleys function below.
	public static int countingValleys(int n, String s) {

		int curVal = 0;
		HashMap<String, Integer> heightMap = new HashMap<String, Integer>();
		heightMap.put("U", 1);
		heightMap.put("D", -1);

		boolean flag = false;
		int rst = 0;
		// s.valueOf(c)

		for (int i = 0; i < n; i++) {
			curVal += heightMap.get(String.valueOf(s.charAt(i)));
			if (curVal < 0) {
				flag = true;
			}

			if (curVal >= 0 && flag == true) {
				rst++;
				flag = false;
			}
		}

		return rst;
	}
}
