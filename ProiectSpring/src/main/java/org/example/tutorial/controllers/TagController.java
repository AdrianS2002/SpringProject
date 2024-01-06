package org.example.tutorial.controllers;

import jakarta.validation.Valid;
import org.example.tutorial.data.TagRepository;
import org.example.tutorial.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping
    public String displayTags(Model model){
        model.addAttribute("title","All Tags");
        model.addAttribute("tags",tagRepository.findAll());
        return "tags/index";
    }

    @GetMapping("create")
    public String displayCreateTagForm(Model model){
        model.addAttribute("title","Create Tag");
        model.addAttribute(new Tag());
        return "tags/create";
    }

    @PostMapping("create")
    public String processCreateTagForm(@ModelAttribute @Valid Tag tag, Errors erros, Model model){
        if(erros.hasErrors()){
            model.addAttribute("title","Create Tag");
            model.addAttribute(tag);
            return "tags/create";
        }
        tagRepository.save(tag);
        return "redirect:/tags";
    }
    @GetMapping("delete")
    public String displayDeleteTagForm(Model model){
        model.addAttribute("title","Delete Tag");
        model.addAttribute("tags",tagRepository.findAll());
        return "tags/delete";
    }

    @PostMapping("delete")
    public String processDeleteTagForm(@RequestParam(required = false) int[] tagIds){
        if(tagIds != null){
            for(int id : tagIds){
                tagRepository.deleteById(id);
            }
        }
        return "redirect:/tags";
    }

}
