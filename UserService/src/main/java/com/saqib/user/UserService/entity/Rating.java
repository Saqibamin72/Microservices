package com.saqib.user.UserService.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private Long hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;


}
