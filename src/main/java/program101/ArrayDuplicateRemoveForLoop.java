package program101;

import java.util.Arrays;

public class ArrayDuplicateRemoveForLoop {
	public static void removeDuplicates(int[] arrayWithDuplicates) {
		System.out.println("Array with Duplicate: ");
		for (int i = 0; i < arrayWithDuplicates.length; i++) {
			System.out.print(arrayWithDuplicates[i] + "\n");
		}

		int noOfUniqueElements = arrayWithDuplicates.length;
		for (int i = 0; i < noOfUniqueElements; i++) {

			for (int j = i + 1; j < noOfUniqueElements; j++) {

				if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
					arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements - 1];
					noOfUniqueElements--;
					j--;
				}

			}
		}
		int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);
		System.out.println();
		System.out.println("Arrays without Duplicates: ");
		for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
			System.out.print(arrayWithoutDuplicates[i] + "\n");

		}
		System.out.println("=======================");

	}

	public static void main(String[] args) {
		removeDuplicates(new int[] { 4, 3, 2, 4, 9, 2 });
		removeDuplicates(new int[] { 1, 2, 1, 2, 1, 2 });
		removeDuplicates(new int[] { 15, 21, 11, 21, 51, 21, 11 });
		removeDuplicates(new int[] { 7, 3, 21, 7, 34, 18, 3, 21 });
	}

}
