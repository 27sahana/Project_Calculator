package com.example.ProjectCal;
import org.springframework.beans.factory.annotation.Autowired;
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
    public double squareRoot(@RequestParam double number) {
    	
        return calculatorService.calculateSquareRoot(number);
    }

    @GetMapping("/factorial")
    public long factorial(@RequestParam int number) {
        return calculatorService.calculateFactorial(number);
    }

    @GetMapping("/modulus")
    public int modulus(@RequestParam int dividend, @RequestParam int divisor) {
        return calculatorService.calculateModulus(dividend, divisor);
    }
}
