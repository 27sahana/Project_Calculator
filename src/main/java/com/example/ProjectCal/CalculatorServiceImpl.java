package com.example.ProjectCal;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	// Calculates the square root of a given number.
	@Override
	public double calculateSquareRoot(double number) {
		return Math.sqrt(number);
	}

	// Calculates the factorial of a non-negative integer.
	@Override
	public long calculateFactorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
		}
		if (number == 0 || number == 1) {
			return 1;
		}
		long result = 1;
		// Calculate the factorial using a loop.
		for (int i = 2; i <= number; i++) {
			result *= i;
		}
		return result;
	}

	// Calculates the modulus of two integers, avoiding division by zero.
	@Override
	public int calculateModulus(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Division by zero is not allowed.");
		}
		return dividend % divisor;
	}
}
