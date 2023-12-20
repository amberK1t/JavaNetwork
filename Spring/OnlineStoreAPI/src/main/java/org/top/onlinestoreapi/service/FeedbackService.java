package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Feedback;

import java.util.Optional;

public interface FeedbackService {

    Iterable<Feedback> findAllByItemId(Integer itemId);
    Optional<Feedback> findById(Integer id);
    Feedback addFeedback(Feedback feedback);
    Optional<Feedback> update(Feedback feedback);
    Optional<Feedback> deleteById(Integer id);

}
