package com.example.apolloapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable())
                .cors(c->c.disable())
                .authorizeHttpRequests((authorize) ->  // potem będzie rozbudowane o uprawnienia użytkowników
                        authorize
                                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
//                                .anyRequest().permitAll() // aplikacja widoczna dla wszystkich i funkcjonalna ->przełącza na inne widoki
                                .requestMatchers("/").permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/adminPanel")).hasAnyRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/lecturerPanel")).hasAnyRole("LECTURER")
                                .requestMatchers(new AntPathRequestMatcher("/studentPanel")).hasAnyRole("STUDENT")

//                                .anyRequest().authenticated() // włączenie widoczności dla użytkowników tylko zalogowanych
                )
                .headers(headers->headers.frameOptions().disable())
                .formLogin(

                        form -> form
                                .loginPage("/home")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }
}

//        http.authorizeRequests()                 // rozpoczyna konfigurację tych zabezpieczeń
//                // BLOK autoryzacji adresów
//                .antMatchers("/students").hasAnyRole("USER")     // antMatchers określa kto ma dostęp do danej ścieżki (czyli w tym wypadku do widoku "students";
//                // jeśli chcemy aby więcej ról miało dostęp do jednego matchers to dodajemy nazwy ról po przecinku np. ("USER", "ADMIN")
//                .antMatchers("/tasks").hasAnyRole("ADMIN")
//                .antMatchers("/js/**", "/css/**", "/vendor/**").permitAll()      // vendor to folder gdzie mamy zewnętrzne gotowe biblioteki jak np. bootstrap
//                .antMatchers("/").permitAll()
//                // BLOK konfiguracja
//                .and()        // jest to rozdział poszczególnych bloków (koniecznie trzeba dać)
//                .csrf().disable()       // wyłącza ochronę przed atakami "csrf" aby w trakcie używania Postman nie wymuszało logoania i hasło
//                .headers().frameOptions().disable()        // headers wyłącza opcje ramek, czyli nie pozwoli nam osadzić naszej strony html w innej stronie html
//                .and()
//                //BLOK autoryzacji logowania i wylogowania
//                .formLogin()  // informuję go , że teraz będę konfigurował formularz autoryzacji
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")  // "password" to jest key na widoczny jedynie na front-end (ten kafelek), a co tam wpisze użytkownik to ustalamy na back-end
//                .loginProcessingUrl("/login")  //
//                .failureForwardUrl("/login?error") // co się stanie w momencie wpisania błędnych danych
//                .defaultSuccessUrl("/")  // co sięstanie w momencie prawidłowego wpisania danych
//                .and().logout() //mówimy springowi, że przechodzimy do obsługi wylogowania
//                .logoutSuccessUrl("/")
//                .logoutUrl("/logout");  // po wylogowaniu gdzie ma nas przekierować
//        return http.build();








//
//@Configuration
//@EnableWebSecurity
//public class Auth {
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();           //jest to zabezpieczenie haseł
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager get() {            // przechowuje dane uwierzetelniające w pamięci
//        UserDetails user = User.withUsername("test")            // nazwa użytkownika; jest to onterfejs który jest wykorzystywany do procesu uwierzetylniania
//                .password(passwordEncoder().encode("test"))            //hasło przepuszczone przez encrypt
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
//    }
//
//    // UserDetail często jest rozszerzany (poza podstawowymi własnościami interfejsu, czyli polami)
//
//
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{   //definicja niestandardowego łańcucha zabezpieczeń
//        http.authorizeRequests()                 // rozpoczyna konfigurację tych zabezpieczeń
//                // BLOK autoryzacji adresów
//                .antMatchers("/students").hasAnyRole("USER")     // antMatchers określa kto ma dostęp do danej ścieżki (czyli w tym wypadku do widoku "students";
//                // jeśli chcemy aby więcej ról miało dostęp do jednego matchers to dodajemy nazwy ról po przecinku np. ("USER", "ADMIN")
//                .antMatchers("/tasks").hasAnyRole("ADMIN")
//                .antMatchers("/js/**", "/css/**", "/vendor/**").permitAll()      // vendor to folder gdzie mamy zewnętrzne gotowe biblioteki jak np. bootstrap
//                .antMatchers("/").permitAll()
//                // BLOK konfiguracja
//                .and()        // jest to rozdział poszczególnych bloków (koniecznie trzeba dać)
//                .csrf().disable()       // wyłącza ochronę przed atakami "csrf" aby w trakcie używania Postman nie wymuszało logoania i hasło
//                .headers().frameOptions().disable()        // headers wyłącza opcje ramek, czyli nie pozwoli nam osadzić naszej strony html w innej stronie html
//                .and()
//                //BLOK autoryzacji logowania i wylogowania
//                .formLogin()  // informuję go , że teraz będę konfigurował formularz autoryzacji
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")  // "password" to jest key na widoczny jedynie na front-end (ten kafelek), a co tam wpisze użytkownik to ustalamy na back-end
//                .loginProcessingUrl("/login")  //
//                .failureForwardUrl("/login?error") // co się stanie w momencie wpisania błędnych danych
//                .defaultSuccessUrl("/")  // co sięstanie w momencie prawidłowego wpisania danych
//                .and().logout() //mówimy springowi, że przechodzimy do obsługi wylogowania
//                .logoutSuccessUrl("/")
//                .logoutUrl("/logout");  // po wylogowaniu gdzie ma nas przekierować
//        return http.build();
