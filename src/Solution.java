import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'calculatePossibleCombinations' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts STRING inputStr as parameter.
	 */

	public static long calculatePossibleCombinations(String inputStr) {
		if (inputStr == null || inputStr.isEmpty() || inputStr.length() == 1 || inputStr.startsWith("0")) 
			return 0;

		if(inputStr.contains("01"))
			return 1;

		int length = inputStr.length();
		List<String> result = new ArrayList<>();
		for(int i=0; i<length-1;i++) {
			for(int j=i+1;j<length;j++){
				String inner = inputStr.substring(i,j);
				if ( inner.length()<3 && Integer.parseInt(inner) < 26 && Integer.parseInt(inner) > 0 ) {
					result.add(inner);
				}
			}
		}
		
		long resSize =0;
		
		for (String string : result) {
			resSize = resSize +1;
		}
		
		return resSize;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String inputStr = bufferedReader.readLine();

		long result = Result.calculatePossibleCombinations(inputStr);

		System.out.println(String.valueOf(result));
		bufferedReader.close();
	}
}
