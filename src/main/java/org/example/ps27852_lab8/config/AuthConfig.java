package org.example.ps27852_lab8.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Sử dụng BCrypt để mã hóa mật khẩu
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .loginPage("/security/login/form")
                        .loginProcessingUrl("/security/login")
                        .defaultSuccessUrl("/security/login/success", false)
                        .failureUrl("/security/login/error")
                        .usernameParameter("username")
                        .passwordParameter("password"))
                .httpBasic(Customizer.withDefaults())
                .csrf(config -> config.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/order/checkout", "/order/viewOrders"
                                , "/order/detail").authenticated()
                        .requestMatchers("/assets/admin/**").hasAnyAuthority("STAF", "DIRE")
                        .anyRequest().permitAll())
                .rememberMe(remb -> remb.tokenValiditySeconds(86400))
                .logout(logout -> logout
                        .logoutUrl("/security/logoff")
                        .logoutSuccessUrl("/security/login/success"))
                .exceptionHandling(excep -> excep.accessDeniedPage("/security/unauthorized"));
        return http.build();
    }
}
