package com.example.saqib.RatingService.RatingService.repository;

import com.example.saqib.RatingService.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
//custom finder methods


   List<Rating> findByUserId(String userId);
   List<Rating>findByHotelId(String hotelId);
}
