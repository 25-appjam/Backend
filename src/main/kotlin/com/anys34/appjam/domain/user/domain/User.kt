package com.anys34.appjam.domain.user.domain

import jakarta.persistence.*

@Entity
class User(
        email: String,
        nickname: String
) {
    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var email: String = email
        protected set

    var nickname: String = nickname
        protected set
}