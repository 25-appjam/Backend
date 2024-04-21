package com.anys34.appjam.domain.todo.service

import com.anys34.appjam.domain.todo.domain.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetListService(
        private val todoRepository: TodoRepository
) {
    @Transactional
    fun execute()
        = todoRepository.findAll()
}