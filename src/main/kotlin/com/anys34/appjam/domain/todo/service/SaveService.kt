package com.anys34.appjam.domain.todo.service

import com.anys34.appjam.domain.todo.domain.repository.TodoRepository
import com.anys34.appjam.domain.todo.presentation.dto.req.TodoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaveService(
        private val todoRepository: TodoRepository
) {
    @Transactional
    fun execute(todoRequest: TodoRequest)
        = todoRepository.save(todoRequest.toEntity())
}