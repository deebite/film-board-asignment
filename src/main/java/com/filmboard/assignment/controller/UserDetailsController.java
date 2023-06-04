package com.filmboard.assignment.controller;

import com.filmboard.assignment.enitity.UserDetails;
import com.filmboard.assignment.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmboard")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/saveuser")
    public UserDetails saveData(@RequestBody UserDetails userDetails){
        return userDetailsService.saveUser(userDetails);
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> users = userDetailsService.getUserDetails();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{username}")
    public  UserDetails getUserData(@PathVariable String username){
        return userDetailsService.getUserDeatilsByID(username);
    }

    @PutMapping("/updateuser/{username}")
    public  UserDetails updateData(@PathVariable String username, @RequestBody UserDetails userDetails){
        return userDetailsService.updateUserBlog(username, userDetails);
    }

    @DeleteMapping("/deleteuser/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userDetailsService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
