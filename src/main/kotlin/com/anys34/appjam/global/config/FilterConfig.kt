package com.anys34.appjam.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.anys34.appjam.global.security.jwt.JwtTokenFilter
import com.anys34.appjam.global.security.jwt.JwtTokenProvider
import com.anys34.appjam.global.config.error.GlobalExceptionFilter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig(
        private val objectMapper: ObjectMapper,
        private val jwtTokenProvider: JwtTokenProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtTokenFilter::class.java)
    }
}