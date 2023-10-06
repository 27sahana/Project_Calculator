package com.example.ProjectCal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

 

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

 

    @GetMapping("/square-root")
    public ResponseEntity<Double> squareRoot(@RequestParam double number) {
        try {
            double result = calculatorService.calculateSquareRoot(number);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., negative number)
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

 

    @GetMapping("/factorial")
    public ResponseEntity<Long> factorial(@RequestParam int number) {
        try {
            long result = calculatorService.calculateFactorial(number);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., negative number)
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

 

    @GetMapping("/modulus")
    public ResponseEntity<Integer> modulus(@RequestParam int dividend, @RequestParam int divisor) {
        try {
            int result = calculatorService.calculateModulus(dividend, divisor);
            return ResponseEntity.ok(result);
        } catch (ArithmeticException e) {
            // Handle division by zero
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}