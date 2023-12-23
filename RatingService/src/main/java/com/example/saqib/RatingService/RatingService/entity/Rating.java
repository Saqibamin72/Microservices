package com.example.saqib.RatingService.RatingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="rating-db")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
