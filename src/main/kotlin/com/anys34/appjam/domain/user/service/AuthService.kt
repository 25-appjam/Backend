package com.anys34.appjam.domain.user.service

import com.anys34.appjam.domain.auth.presentation.dto.res.TokenResponse
import com.anys34.appjam.domain.user.domain.User
import com.anys34.appjam.domain.user.domain.repository.UserRepository
import com.anys34.appjam.domain.user.exception.UserIncorrectException
import com.anys34.appjam.domain.user.exception.UserNotFoundException
import com.anys34.appjam.domain.user.presentation.dto.req.LoginRequest
import com.anys34.appjam.global.feign.auth.GoogleInformationClient
import com.anys34.appjam.global.feign.auth.dto.res.GoogleInformationResponse
import com.anys34.appjam.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val jwtTokenProvider: JwtTokenProvider,
        private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(loginRequest: LoginRequest): TokenResponse {
        val user = userRepository.findByEmail(loginRequest.email)
                ?: throw UserNotFoundException

        if (!passwordEncoder.matches(loginRequest.password, user.password)) {
            throw UserIncorrectException
        }

        return TokenResponse(
                jwtTokenProvider.createAccessToken(loginRequest.email)
        )
    }
}