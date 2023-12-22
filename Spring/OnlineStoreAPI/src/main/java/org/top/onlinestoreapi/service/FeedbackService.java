package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Feedback;

import java.util.Optional;

public interface FeedbackService {
    Feedback addFeedback(Feedback feedback);
    Optional<Feedback> deleteById(Integer id);

}
