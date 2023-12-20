package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Feedback;
import org.top.onlinestoreapi.rdb.repository.FeedbackRepository;
import org.top.onlinestoreapi.service.FeedbackService;

import java.util.Date;
import java.util.Optional;

@Service
public class RdbFeedbackService implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public RdbFeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Iterable<Feedback> findAllByItemId(Integer itemId) {

        return null;
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        feedback.setWrittenDate(new Date());
        return feedbackRepository.save(feedback);
    }

    @Override
    public Optional<Feedback> update(Feedback feedback) {
        return Optional.empty();
    }

    @Override
    public Optional<Feedback> deleteById(Integer id) {
        return Optional.empty();
    }
}
