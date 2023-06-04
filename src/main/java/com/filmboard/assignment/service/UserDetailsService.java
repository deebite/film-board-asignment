package com.filmboard.assignment.service;

import com.filmboard.assignment.enitity.UserDetails;

import java.util.List;

public interface UserDetailsService {

    UserDetails saveUser(UserDetails userDetails);

    List<UserDetails> getUserDetails();

    UserDetails getUserDeatilsByID(String username);

    UserDetails updateUserBlog(String username, UserDetails userDetails);

    void deleteUser(String username);
}
