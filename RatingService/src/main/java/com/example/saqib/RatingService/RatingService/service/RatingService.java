package com.example.saqib.RatingService.RatingService.service;


import com.example.saqib.RatingService.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);
    List<Rating> getAllRatings();

    List<Rating>getRatingByUserId(String UserId);
    List<Rating>getRatingByHotelId(String hotelId);


}
