package exemplos.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quadruplets {

	public static void main(String[] args) {
		int[] firstSetOfNumber = { 7, 6 ,4, -1, 1, 2 };
		int firstTarget = 16;
		printQuadruplets(fourNumberSum(firstSetOfNumber, firstTarget));
		
		System.out.println("\n------------------------");
		
		int[] secondSetOfNumber = {1, 2, 3, 4, -2, 6, 7, 8};
		int secondTarget = 10;
		printQuadruplets(fourNumberSum(secondSetOfNumber, secondTarget));
		
		System.out.println("\n------------------------");
		
		int[] thirdSetOfNumber = {2, 4, -3, 5, 7, 1, 10};
		int thirdTarget = 12;
		printQuadruplets(fourNumberSum(thirdSetOfNumber, thirdTarget));
	}
	
	public static void printQuadruplets(List<Integer[]> quadruplets) {
		quadruplets.forEach(member -> {
			System.out.print(Stream.of(member).map(number -> number.toString()).collect(Collectors.joining(", ", "[", "]")));
		});
	}
	
	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		List<Integer[]> groups = new ArrayList<>();
		
		Arrays.sort(array);
		
		for (int firstTimeIndex = 0; firstTimeIndex <= array.length - 4; firstTimeIndex++) {
	        for (int secondTimeIndex = firstTimeIndex + 1; secondTimeIndex <= array.length - 3; secondTimeIndex++) {
	            int remaining = targetSum - (array[firstTimeIndex] + array[secondTimeIndex]);

	            int sequence = secondTimeIndex + 1;
	            int lastNumber = array.length - 1;

	            while (sequence < lastNumber) {
	                if (array[sequence] + array[lastNumber] < remaining) {
	                    sequence++;
	                    continue;
	                }
	                if (array[sequence] + array[lastNumber] > remaining) {
	                    lastNumber--;
	                    continue;
	                }
	                
                	Integer[] numbers = new Integer[4];
                	numbers[0] = array[firstTimeIndex];
                	numbers[1] = array[secondTimeIndex];
                	numbers[2] = array[sequence];
                	numbers[3] = array[lastNumber];
                	groups.add(numbers);
                    sequence++;
                    lastNumber--;
	            }
	        }
	    }
		
		return groups;
	}
}
