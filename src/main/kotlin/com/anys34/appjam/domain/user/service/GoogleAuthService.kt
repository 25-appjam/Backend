package com.anys34.appjam.domain.user.service

import com.anys34.appjam.domain.auth.presentation.dto.res.TokenResponse
import com.anys34.appjam.domain.user.domain.User
import com.anys34.appjam.domain.user.domain.repository.UserRepository
import com.anys34.appjam.domain.user.exception.SchoolUserNotException
import com.anys34.appjam.global.feign.auth.GoogleInformationClient
import com.anys34.appjam.global.feign.auth.dto.res.GoogleInformationResponse
import com.anys34.appjam.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoogleAuthService(
        private val userRepository: UserRepository,
        private val jwtTokenProvider: JwtTokenProvider,
        private val googleInformationClient: GoogleInformationClient
) {
    @Transactional
    fun execute(accessToken: String): TokenResponse {
        val response: GoogleInformationResponse = googleInformationClient
                .getInformation(accessToken)
        val email: String = response.email

        userRepository.findByEmail(email)
                ?: userRepository.save(User(
                        email,
                        response.name
                ))

        return TokenResponse(
                jwtTokenProvider.createAccessToken(email)
        )
    }
}