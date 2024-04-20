package com.anys34.appjam.domain.user.domain

import jakarta.persistence.*
import java.util.UUID

@Entity
class User(
        name: String,
        email: String,
        password: String,
        familyName: String
) {
    @Column(name = "user_id")
    @Id
    val id: UUID = UUID.randomUUID()

    var name: String = name
        protected set

    var email: String = email
        protected set

    var password: String = password
        protected set

    var familyName: String = familyName
        protected set
}