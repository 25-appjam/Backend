package com.anys34.appjam.domain.user.domain.repository

import com.anys34.appjam.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun findByEmailAndPassword(email: String, password: String): User?
}