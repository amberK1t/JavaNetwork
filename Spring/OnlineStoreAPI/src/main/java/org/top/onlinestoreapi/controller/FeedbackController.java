package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.top.onlinestoreapi.entity.Feedback;
import org.top.onlinestoreapi.service.FeedbackService;

import java.util.Optional;

@Controller
@RequestMapping("feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("new")
    public String postAddForm(Feedback feedback) {
        feedbackService.addFeedback(feedback);
        Integer itemId = feedback.getItem().getId();
        return "redirect:/item/" + itemId;
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        Optional<Feedback> deleted = feedbackService.deleteById(id);
        return deleted.map(feedback -> "redirect:/item/" + feedback.getItem().getId()).orElse("error");
    }

}
