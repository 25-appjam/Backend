package com.anys34.appjam.domain.todo.service

import com.anys34.appjam.domain.todo.domain.repository.TodoRepository
import com.anys34.appjam.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClearService(
        private val todoRepository: TodoRepository
) {
    @Transactional
    fun execute(id: Long) {
        val post = todoRepository.findByIdOrNull(id) ?: throw UserNotFoundException
        post.clear()
    }
}