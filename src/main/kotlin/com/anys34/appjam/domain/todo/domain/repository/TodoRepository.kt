package com.anys34.appjam.domain.todo.domain.repository

import com.anys34.appjam.domain.todo.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}