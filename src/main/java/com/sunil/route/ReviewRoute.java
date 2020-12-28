package com.sunil.route;

import com.sunil.datamodel.dto.ReviewDTO;
import com.sunil.datamodel.vo.ReviewRegisterVO;
import com.sunil.service.ReviewService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "리뷰 기초 생성")
    @GetMapping("/initialize")
    public void initialize() {
        this.reviewService.initializeReviews();
    };

    @ApiOperation(value = "리뷰 전체 조회")
    @GetMapping("")
    public List<ReviewDTO> getReviews() {
        return this.reviewService.reviews();
    };

    @ApiOperation(value = "리뷰 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reviewId", value = "리뷰 ID", required = true, dataType = "string"),
    })
    @GetMapping("/{reviewId}")
    public ReviewDTO getReviewByReviewId(@PathVariable(value = "reviewId") String reviewId) throws Exception{
        return this.reviewService.reviewByReviewId(Integer.parseInt(reviewId));
    };

    @ApiOperation(value = "리뷰 생성")
    @PostMapping
    public int createReview(ReviewRegisterVO review) {
        return this.reviewService.createReview(review);
    };

    @ApiOperation(value = "리뷰 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reviewId", value = "리뷰 ID", required = true, dataType = "string"),
    })
    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable(value = "reviewId") String reviewId) {
        this.reviewService.deleteReview(Integer.parseInt(reviewId));
    };
};
