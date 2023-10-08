package com.example.ProjectCal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    // Constructor to inject CalculatorService dependency
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // Endpoint for calculating square root
    @GetMapping("/square-root")
    public ResponseEntity<Double> squareRoot(@RequestParam double number) {
        try {
            // Call the calculatorService to calculate the square root
            double result = calculatorService.calculateSquareRoot(number);
            // Return a successful response with the result
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., negative number) with a bad request response
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions with an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint for calculating factorial
    @GetMapping("/factorial")
    public ResponseEntity<Long> factorial(@RequestParam int number) {
        try {
            // Call the calculatorService to calculate the factorial
            long result = calculatorService.calculateFactorial(number);
            // Return a successful response with the result
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., negative number) with a bad request response
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions with an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint for calculating modulus
    @GetMapping("/modulus")
    public ResponseEntity<Integer> modulus(@RequestParam int dividend, @RequestParam int divisor) {
        try {
            // Call the calculatorService to calculate the modulus
            int result = calculatorService.calculateModulus(dividend, divisor);
            // Return a successful response with the result
            return ResponseEntity.ok(result);
        } catch (ArithmeticException e) {
            // Handle division by zero with a bad request response
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions with an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
