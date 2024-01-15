package org.example.tutorial.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.tutorial.data.EventCategoryRepository;
import org.example.tutorial.data.EventRepository;
import org.example.tutorial.data.TagRepository;
import org.example.tutorial.models.Event;
import org.example.tutorial.models.EventCategory;
import org.example.tutorial.models.Tag;
import org.example.tutorial.models.dto.EventTagDTO;
import org.example.tutorial.service.event.EventService;
import org.example.tutorial.service.eventCategory.EventCategoryService;
import org.example.tutorial.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventCategoryService eventCategoryService;

    @Autowired
    private TagService tagService;


    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer categoryId, Model model) {

        if(categoryId ==null)
        {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventService.findAll());
        }else{
            Optional<EventCategory> result =  eventCategoryService.findById(categoryId);
            if (result.isEmpty()){
               model.addAttribute("title", "Invalid Category ID: "+ categoryId);
            }else{
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: "+ category.getName());
                model.addAttribute("events",category.getEvents());
            }
        }

        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories",eventCategoryService.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title","Create Event");
            return "events/create";
        }
        eventService.save(newEvent);
        return "redirect:/events";   // redirect to the root path
    }


    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events", eventService.findAll());
        return "events/delete";
    }
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null){
            for(int id: eventIds){
                eventService.deleteById(id);
            }
        }
        return "redirect:/events";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventService.findById(eventId);
        if(result.isEmpty()){
            model.addAttribute("title","Invalid Event ID: "+ eventId);
        }else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }
        return "events/detail";
    }

    //responds to /events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventService.findById(eventId);
        Event event = result.get();
        model.addAttribute("title","Add Tag to: "+ event.getName());
        model.addAttribute("tags",tagService.findAll());
        EventTagDTO eventTag = new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag",eventTag);
        return "events/add-tag";
    }
    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag,
                                    Errors errors, Model model){
        if(!errors.hasErrors()){
            Event event = eventTag.getEvent();
            Tag tag = eventTag.getTag();
            if(!event.getTags().contains(tag)){
                event.addTag(tag);
                eventService.save(event);
            }
            return "redirect:detail?eventId="+event.getId();
        }
        return "redirect:add-tag";
    }

}
