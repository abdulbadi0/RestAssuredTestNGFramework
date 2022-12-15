package program101;

import java.util.Arrays;

public class Array2Equal {

	public static void main(String[] args) {
		int arr1[] = { 2, 4, 65, 87, 21, 9, 32, 90 };
		int arr2[] = { 2, 4, 65, 87, 21, 9, 32, 90 };

		boolean equalORNot = true;

		if (arr1.length == arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					equalORNot = false;
				}
			}
		} else {
			equalORNot = false;
		}
		if (equalORNot) {
			System.out.println("Both array are equal");
		} else {
			System.out.println("Both array are Not equal");
		}

		String[] s1 = { "java", "j2ee", "struts", "hibernate" };
		String[] s2 = { "jsp", "spring", "jdbc", "hibernate" };
		String[] s3 = { "java", "j2ee", "struts", "hibernate" };
		System.out.println(Arrays.equals(s1, s2));
		System.out.println(Arrays.equals(s1, s3));
		
	}

}
