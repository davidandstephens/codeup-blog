package com.codeup.codeupblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String guess() {
        return "guess";
    }

    @GetMapping("/roll-dice/{number}")
    public String checkingGuess(@PathVariable int number, Model model) {
        int magicNumber = (int) (Math.floor(Math.random() * 6) + 1);
        boolean checker = magicNumber == number;
        model.addAttribute("number", number);
        model.addAttribute("magicNumber", magicNumber);
        model.addAttribute("checker", checker);
        return "dice-roll-check";
    }
}
