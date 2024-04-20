package com.anys34.appjam.global.security.principal

import com.anys34.appjam.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
        private val userFacade: UserFacade
): UserDetailsService {
    override fun loadUserByUsername(email: String)
        = AuthDetails(userFacade.getUserByEmail(email))
}