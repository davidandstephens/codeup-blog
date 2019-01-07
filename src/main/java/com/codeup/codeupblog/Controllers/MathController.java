package com.codeup.codeupblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        int sum = num1 + num2;
        return "When you add " + num1 + " and " + num2 + ", you get " + sum + "!";
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        int difference = num2 - num1;
        return "When you subtract " + num1 + " from " + num2 + ", you get " + difference + "!";
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        int product = num2 * num1;
        return "When you multiply " + num1 + " by " + num2 + ", you get " + product + "!";
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        int quotient = num1 / num2;
        return "When you divide " + num1 + " by " + num2 + ", you get " + quotient + "!";
    }
}
