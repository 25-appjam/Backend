package com.anys34.appjam.domain.user.facade

import com.anys34.appjam.domain.user.domain.User
import com.anys34.appjam.domain.user.domain.repository.UserRepository
import com.anys34.appjam.domain.user.exception.UserNotFoundException
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

@Configuration
class UserFacade(
        private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val email: String = SecurityContextHolder.getContext().authentication.name
        return getUserByEmail(email)
    }

    fun getUserByEmail(email: String)
        = userRepository.findByEmail(email) ?: throw UserNotFoundException

    fun isLogin(): Boolean {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication == null || authentication is AnonymousAuthenticationToken) return false
        return authentication.isAuthenticated
    }
}