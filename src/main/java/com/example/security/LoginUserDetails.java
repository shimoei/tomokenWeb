package com.example.security;

import com.example.users.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
    private final User user;

    public LoginUserDetails(User user){
        //パスワードはエンコード後の値を格納する。
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}
