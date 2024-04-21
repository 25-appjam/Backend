package com.anys34.appjam.domain.todo.presentation.dto.req

import com.anys34.appjam.domain.todo.domain.Todo

class TodoRequest(
        val name: String,
        val content: String
) {
    fun toEntity()
        = Todo(
                name,
                content
        )
}