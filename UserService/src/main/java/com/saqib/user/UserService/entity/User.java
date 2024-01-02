package com.saqib.user.UserService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user-db")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id

    @Column(name = "ID")
    private String userID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;
    @Transient
    private List<Rating>ratings= new ArrayList<>();
}






