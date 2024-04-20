package com.anys34.appjam.global.config

import com.anys34.appjam.global.security.jwt.JwtTokenFilter
import com.anys34.appjam.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val objectMapper: ObjectMapper,
        private val jwtProvider: JwtTokenProvider
) {
    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .cors()

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(JwtTokenFilter(jwtProvider),
                UsernamePasswordAuthenticationFilter::class.java)

        http
            .authorizeRequests()
            .anyRequest().permitAll()

        http.exceptionHandling().authenticationEntryPoint(
                HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

        http
            .apply(FilterConfig(objectMapper, jwtProvider))

        return http.build()
    }
}