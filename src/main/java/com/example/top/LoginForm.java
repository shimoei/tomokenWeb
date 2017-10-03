package com.example.top;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginForm {

    // ユーザ名
    String username;

    // パスワード
    String password;
}
