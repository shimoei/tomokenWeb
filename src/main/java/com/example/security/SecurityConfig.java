package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        //静的リソースにセキュリティ設定を除外する。
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // antPatternsのurlのみ認可不要にする。
        http.authorizeRequests()
                .antMatchers("/top").permitAll()
                .anyRequest().authenticated();

        //ログインの設定
        http.formLogin()
                .loginProcessingUrl("/login")//認証処理のパス
                .loginPage("/top")//ログインフォーム表示のパス
                .failureUrl("/top?error")//認証失敗時の遷移先
                .defaultSuccessUrl("/users/top", true)//認証成功時の遷移先
                .usernameParameter("username")//user名のパラメータ名
                .passwordParameter("password");//パスワードのパラメータ名

        //ログアウトの設定
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/top");

    }

    @Configuration
    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        UserDetailsService userDetailsService;

        @Bean
        PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
            //.passwordEncoder(passwordEncoder());  パスワードのエンコードの設定
        }
    }
}
