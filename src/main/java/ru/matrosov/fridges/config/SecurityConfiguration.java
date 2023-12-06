//package ru.matrosov.fridges.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                //.csrf(withDefaults())
//                .cors((cors) -> cors
//                        .configurationSource(corsConfigurationSource())
//                )
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(withDefaults())
//                .formLogin(withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*"); // Разрешить запросы от любого источника
//        configuration.addAllowedMethod("*"); // Разрешить любые HTTP-методы
//        configuration.addAllowedHeader("*"); // Разрешить любые заголовки
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
