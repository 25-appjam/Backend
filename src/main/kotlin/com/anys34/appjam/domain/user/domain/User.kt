package com.anys34.appjam.domain.user.domain

import jakarta.persistence.*

@Entity
class User(
        email: String,
        password: String,
        familyName: String
) {
    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var email: String = email
        protected set

    var password: String = password
        protected set

    var familyName: String = familyName
        protected set
}