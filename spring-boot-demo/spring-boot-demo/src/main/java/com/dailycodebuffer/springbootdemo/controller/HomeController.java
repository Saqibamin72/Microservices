package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
   // @RequestMapping("/user")
   // @RequestMapping(value = "/user",Method= RequestMethod.POST)
    //@RequestMapping(value = "/user",Method= RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user=new User();
        user.setId("1");
        user.setName("Saqib");
        user.setEmailId("saqib@gmail.com");
        return user;
    }
    @GetMapping("/{id}/{id2}")
  //  public String pathVariable(@PathVariable String id){
    //public String pathVariable(@PathVariable String id, @PathVariable String id2)
    public String pathVariable(@PathVariable String id, @PathVariable("id2")String name)
    {
    return "The path variable is:"+id+":"+name;
    }
    @GetMapping("/requestParams")
   // public String requestParams(@RequestParam String name,@RequestParam String emailId){
    //public String requestParams(@RequestParam String name,@RequestParam (name="email")String emailId){
    public String requestParams(@RequestParam String name,@RequestParam (name="email",required = false,defaultValue = " ")String emailId){

        return "your name is:"+name+"and EmailID is:"+emailId;
    }
}


