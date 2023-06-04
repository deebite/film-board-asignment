package com.filmboard.assignment.service.impl;

import com.filmboard.assignment.enitity.UserDetails;
import com.filmboard.assignment.exception.ResourceNotFoundException;
import com.filmboard.assignment.repository.UserDetailsRepository;
import com.filmboard.assignment.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails saveUser(UserDetails userDetails) {
        UserDetails singleUser = new UserDetails();
        singleUser.setUsername(userDetails.getUsername());
        singleUser.setUser_blog(userDetails.getUser_blog());
        userDetailsRepository.save(userDetails);
        return userDetails;
    }

    @Override
    public List<UserDetails> getUserDetails() {
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        return userDetailsList;
    }


    @Override
    public UserDetails getUserDeatilsByID(String username) {
        UserDetails existingUserDetails = userDetailsRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("USER NOT FOUND", username));
        return existingUserDetails;
    }

    @Override
    public UserDetails updateUserBlog(String username, UserDetails userDetails) {
        UserDetails existingUserDetails = userDetailsRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("USER NOT FOUND", username));
        existingUserDetails.setUsername(userDetails.getUsername());
        existingUserDetails.setUser_blog(userDetails.getUser_blog());
        userDetailsRepository.save(existingUserDetails);
        return existingUserDetails;
    }

    @Override
    public void deleteUser(String username) {
        UserDetails existingUserDetails = userDetailsRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("USER NOT FOUND", username));
        userDetailsRepository.delete(existingUserDetails);
    }


}
