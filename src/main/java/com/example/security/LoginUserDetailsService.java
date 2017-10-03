package com.example.security;

import com.example.users.User;
import com.example.users.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //apiを叩いてユーザを検索する。
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/api/users/username?username=" + username;

        UserForm userform = restTemplate.getForObject(url, UserForm.class);
        User user = new User(userform.getId(), userform.getUsername(), userform.getPassword(), userform.getMail());

        return new LoginUserDetails(user);
    }

}
