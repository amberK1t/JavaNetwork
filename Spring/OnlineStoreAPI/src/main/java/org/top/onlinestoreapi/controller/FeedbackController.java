package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.top.onlinestoreapi.entity.Feedback;
import org.top.onlinestoreapi.service.FeedbackService;

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

}
