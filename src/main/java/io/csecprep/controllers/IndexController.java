package io.csecprep.controllers;

import io.csecprep.utility.ViewHelpers;
import io.csecprep.entities.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("")
    public String index(Model model){
        List<Subject> subjectList = new ArrayList<>(List.of(Subject.values()));

        model.addAttribute("imageHelper", new ViewHelpers());
        model.addAttribute("subjects", subjectList);

        return "index";
    }
}
