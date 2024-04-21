package com.anys34.appjam.domain.todo.service

import com.anys34.appjam.domain.todo.domain.repository.TodoRepository
import com.anys34.appjam.domain.todo.presentation.dto.req.updateRequest
import com.anys34.appjam.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateService(
        private val todoRepository: TodoRepository
) {
    @Transactional
    fun execute(id: Long, updateRequest: updateRequest) {
        val todo = todoRepository.findByIdOrNull(id) ?: throw UserNotFoundException
        return todo.update(updateRequest.content)
    }
}