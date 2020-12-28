package com.sunil.service;

import com.sunil.datamodel.dto.ReviewDTO;
import com.sunil.datamodel.exception.ControllableException;
import com.sunil.datamodel.vo.ReviewRegisterVO;
import com.sunil.model.Review;
import com.sunil.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    };

    public ReviewDTO reviewByReviewId(int reviewId) throws Exception {
        Optional<Review> searchedReview = this.reviewRepository.findById(reviewId);

        return new ReviewDTO(searchedReview.orElseThrow(() -> new ControllableException("존재하지 않는 리뷰 아이디 입니다")));
    };

    public List<ReviewDTO> reviews() {
        return this.reviewRepository.findAll().stream().map(ReviewDTO::new).collect(Collectors.toList());
    };

    public int createReview(ReviewRegisterVO reviewRegisterVO) {
        Review createReview = Review.builder()
                .userId(reviewRegisterVO.getUserId())
                .productId(reviewRegisterVO.getProductId())
                .content(reviewRegisterVO.getContent())
                .rate(reviewRegisterVO.getRate())
                .reviewDate(new Date())
                .build();

        this.reviewRepository.save(createReview);
        this.reviewRepository.flush();

        return createReview.getReviewId();
    };

    public void deleteReview(int reviewId) {
        this.reviewRepository.deleteById(reviewId);
    };

    public void initializeReviews() {
        Review review1 = Review.builder()
                .userId(1)
                .productId(2)
                .content("정말 좋네요!")
                .rate((float) 5.0)
                .reviewDate(new Date())
                .build();

        Review review2 = Review.builder()
                .userId(3)
                .productId(1)
                .content("배송 빨라서 좋네요")
                .rate((float) 4.5)
                .reviewDate(new Date())
                .build();

        Review review3 = Review.builder()
                .userId(2)
                .productId(3)
                .content("무난합니다")
                .rate((float) 3.0)
                .reviewDate(new Date())
                .build();

        this.reviewRepository.save(review1);
        this.reviewRepository.save(review2);
        this.reviewRepository.save(review3);

        this.reviewRepository.flush();
    };
};
