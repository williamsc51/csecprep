package io.csecprep.controllers;

import io.csecprep.entities.Subjects;
import io.csecprep.utility.ViewHelpers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("")
    public String index(Model model){
        List<Subjects> subjectsList = new ArrayList<>(List.of(Subjects.values()));

        model.addAttribute("subjects", subjectsList);
        model.addAttribute("imageHelper", new ViewHelpers());

        return "index";
    }
}
