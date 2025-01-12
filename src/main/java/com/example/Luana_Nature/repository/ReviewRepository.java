package com.example.Luana_Nature.repository;


import com.example.Luana_Nature.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT review.rating AS rating, COUNT(review) AS count FROM Review review GROUP BY review.rating")
    List<Map<String, Object>> countReviewsByRating();

}
