package program101;

import java.util.Arrays;

public class ArrayReverse {

	public static void reverseArray(int[] inputArray) {

		System.out.println("Array before Reverse: " + Arrays.toString(inputArray));
		int temp;
		for (int i = 0; i <= inputArray.length / 2; i++) {
			temp = inputArray[i];
			inputArray[i] = inputArray[inputArray.length - 1 - i];
			inputArray[inputArray.length - 1 - i] = temp;
		}
		System.out.println("Array After Reverse: " + Arrays.toString(inputArray));
	}

	public static void main(String[] args) {

		reverseArray(new int[] { 4, 5, 7, 9, 0, 1, 6 });
		System.out.println("---------------------");
		reverseArray(new int[] { 12, 9, 21, 17, 33, 7 });
		System.out.println("-------------------------");
		reverseArray(new int[] { 891, 569, 921, 187, 343, 476, 555 });

	}

}
