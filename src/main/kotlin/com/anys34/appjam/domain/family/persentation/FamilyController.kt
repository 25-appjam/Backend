package com.anys34.appjam.domain.family.persentation

import com.anys34.appjam.domain.family.persentation.dto.req.AddRequest
import com.anys34.appjam.domain.family.service.AddService
import com.anys34.appjam.domain.user.facade.UserFacade
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "가족 초대 서비스")
@RequestMapping("/family")
@RestController
class FamilyController(
        private val userFacade: UserFacade,
        private val addService: AddService
) {
    @Operation(summary = "가족 초대 코드")
    @GetMapping
    fun code()
        = userFacade.getCurrentUser().id

    @Operation(summary = "가족 구성원 생성")
    @PostMapping
    fun add(@RequestBody addRequest: AddRequest)
        = addService.execute(addRequest)
}