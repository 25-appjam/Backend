package com.anys34.appjam.domain.todo.presentation

import com.anys34.appjam.domain.todo.presentation.dto.req.TodoRequest
import com.anys34.appjam.domain.todo.presentation.dto.req.updateRequest
import com.anys34.appjam.domain.todo.service.ClearService
import com.anys34.appjam.domain.todo.service.GetListService
import com.anys34.appjam.domain.todo.service.SaveService
import com.anys34.appjam.domain.todo.service.UpdateService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Todo 리스트")
@RequestMapping("/todo")
@RestController
class TodoController(
        private val saveService: SaveService,
        private val updateService: UpdateService,
        private val getListService: GetListService,
        private val clearService: ClearService
) {
    @Operation(summary = "todo 저장")
    @PostMapping
    fun save(@RequestBody todoRequest: TodoRequest)
        = saveService.execute(todoRequest)

    @Operation(summary = "todo 수정")
    @PutMapping
    fun update(@RequestParam("id") id: Long, @RequestBody updateRequest: updateRequest)
        = updateService.execute(id, updateRequest)

    @Operation(summary = "todo 리스트")
    @GetMapping
    fun getList()
        = getListService.execute()

    @Operation(summary = "todo 완료")
    @GetMapping("/clear")
    fun clear(@RequestParam("id") id: Long)
        = clearService.execute(id)
}