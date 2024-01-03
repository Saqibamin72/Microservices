package com.saqib.user.UserService.service;

import com.saqib.user.UserService.entity.Hotel;
import com.saqib.user.UserService.entity.Rating;
import com.saqib.user.UserService.entity.User;
import com.saqib.user.UserService.exception.ResourceNotFoundException;
import com.saqib.user.UserService.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomUUID= UUID.randomUUID().toString();
        user.setUserID(randomUUID);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id not found!!"+userId));
       // ArrayList<Rating> ratingsOfUser=restTemplate.getForObject("http://localhost:8082/ratings/users/"+user.getUserID(),ArrayList.class);
        Rating[] ratingsOfUser=restTemplate.getForObject("http://localhost:8082/ratings/users/"+user.getUserID(),Rating[].class);

        log.info("{}",ratingsOfUser);
       List<Rating>ratings= Arrays.stream(ratingsOfUser).toList();


      List<Rating>ratingList=  ratings.stream().map(rating -> {

      ResponseEntity<Hotel>forEntity=restTemplate.getForEntity("http://localhost:8081/hotels/"+rating.getHotelId(), Hotel.class);
      Hotel hotel=forEntity.getBody();
      log.info("response status code{}",forEntity.getStatusCode());
      rating.setHotel(hotel);
      return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;

    }
}
