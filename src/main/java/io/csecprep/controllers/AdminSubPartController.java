package io.csecprep.controllers;

import io.csecprep.entities.SubPart;
import io.csecprep.service.SubPartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminSubPartController {

    private final SubPartService subPartService;

    AdminSubPartController(SubPartService subPartService){
        this.subPartService = subPartService;
    }

    @PostMapping("/sub_part")
    public ModelAndView createSubPart(@ModelAttribute SubPart subPart){
        SubPart response = subPartService.save(subPart);

        return new ModelAndView("redirect:/admin/questions/" + response.getQuestion().getId().toString());
    }
}
