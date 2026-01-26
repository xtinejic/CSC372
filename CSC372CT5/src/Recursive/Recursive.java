package Recursive;

import java.util.Scanner;

public class Recursive {
	public static void main(String[] args ) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Calculator using Recursion");
		System.out.println("==================");
		System.out.println("Enter five numbers:");
		
		double[] numbers = new double[5];
		
		for (int i = 0; i < 5; i ++) {
			System.out.print("Number " + (i + 1) + ": ");
			numbers[i] = scanner.nextDouble();
		}
		
		double product = calculateProduct(numbers, 0);
		
		System.out.println("\n The result of all five numbers is: " + product);
		
		scanner.close();
	}

	private static double calculateProduct(double[] numbers, int index) {
		if (index == numbers.length - 1) {
			return numbers[index];
		}
		
		return numbers[index] * calculateProduct(numbers, index + 1);
	}
}
