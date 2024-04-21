package com.anys34.appjam.domain.todo.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Todo(
        name: String,
        content: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var name: String = name

    var content: String = content

    var check: Boolean = false

    fun update(
            content: String
    ) {
        this.content = content
    }

    fun clear() {
        check = !check
    }
}