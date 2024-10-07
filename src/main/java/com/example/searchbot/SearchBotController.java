package com.example.searchbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchBotController {

    @Autowired
    private SearchBotService searchbotService;

    @GetMapping("/")
    public String question(Model model) {
        return "question";  // Return the view where the user can ask a question
    }

    @PostMapping("/answer")
    public String answer(@RequestParam String question, Model model) {
        String response = searchbotService.getResponse(question);
        System.out.println(response);
        model.addAttribute("response", response);  // Display the chatbot's response
        return "response";
    }
}
