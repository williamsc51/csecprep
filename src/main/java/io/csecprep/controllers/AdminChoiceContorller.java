package io.csecprep.controllers;

import io.csecprep.entities.Choice;
import io.csecprep.service.ChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminChoiceContorller {

    private final ChoiceService choiceService;

    AdminChoiceContorller(ChoiceService choiceService){
        this.choiceService = choiceService;
    }

    @PostMapping("/choices")
    public ModelAndView createChoice(@ModelAttribute Choice choice){
        Choice response = choiceService.save(choice);

        return new ModelAndView("redirect:/admin/questions/" + response.getQuestion().getId().toString());
    }
}
