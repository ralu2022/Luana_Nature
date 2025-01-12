package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.Review;
import com.example.Luana_Nature.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /* Viualizare review-uri */
    @GetMapping("/reviews")
    public String allReviews(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "reviews";
    }

    /* Adăugare review */
    @GetMapping("/review")
    public String reviewPage(Model model) {
        model.addAttribute("review", new Review());
        return "reviewform";
    }
    @PostMapping("/addReview")
    public String addReview(@RequestParam int rating,
                            @RequestParam String comment){
        reviewService.addReview(rating, comment);
        return "redirect:/reviews/reviews";
    }

    /* Statistică review-uri */
    @GetMapping("/countReviewsByRating")
    @ResponseBody
    public List<Map<String,Object>> getReviewCountByRating(){
        return reviewService.getReviewCountByRating();}
    @GetMapping("reviewChart")
    public String reviewChart(Model model){
        List<Map<String, Object>>reviewData = reviewService.getReviewCountByRating();
        model.addAttribute("reviewData", reviewData);
        return "redirect:/mainpageuser";
    }
}
