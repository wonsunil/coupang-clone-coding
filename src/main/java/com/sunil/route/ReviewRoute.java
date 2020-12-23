package com.sunil.route;

import com.sunil.datamodel.dto.ReviewDTO;
import com.sunil.datamodel.vo.ReviewRegisterVO;
import com.sunil.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewRoute {
    private final ReviewService reviewService;

    @Autowired
    public ReviewRoute(ReviewService reviewService) {
        this.reviewService = reviewService;
    };

    @GetMapping("")
    public List<ReviewDTO> getReviews() {
        return this.reviewService.reviews();
    };

    @GetMapping("/{reviewId}")
    public ReviewDTO getReviewByReviewId(@PathVariable(value = "reviewId") String reviewId) throws Exception{
        return this.reviewService.reviewByReviewId(Integer.parseInt(reviewId));
    };

    @PostMapping
    public int createReview(ReviewRegisterVO review) {
        return this.reviewService.createReview(review);
    };

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable(value = "reviewId") String reviewId) {
        this.reviewService.deleteReview(Integer.parseInt(reviewId));
    };
};
