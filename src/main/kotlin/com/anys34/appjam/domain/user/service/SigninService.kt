package com.anys34.appjam.domain.user.service

import com.anys34.appjam.domain.auth.presentation.dto.res.TokenResponse
import com.anys34.appjam.domain.user.domain.User
import com.anys34.appjam.domain.user.domain.repository.UserRepository
import com.anys34.appjam.domain.user.exception.UserSameException
import com.anys34.appjam.domain.user.presentation.dto.req.SigninRequest
import com.anys34.appjam.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SigninService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val jwtTokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(signinRequest: SigninRequest): TokenResponse {
        val user = userRepository.findByEmail(signinRequest.email)

        if(user != null)
            throw UserSameException

        userRepository.save(User(
                signinRequest.email,
                passwordEncoder.encode(signinRequest.password),
                signinRequest.familyName
        ))

        return TokenResponse(
                jwtTokenProvider.createAccessToken(signinRequest.email)
        )
    }
}