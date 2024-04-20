package com.anys34.appjam.domain.family.persentation

import com.anys34.appjam.domain.family.persentation.dto.req.AddRequest
import com.anys34.appjam.domain.family.persentation.dto.req.CodeRequest
import com.anys34.appjam.domain.family.service.AddService
import com.anys34.appjam.domain.family.service.FamilyListService
import com.anys34.appjam.domain.user.facade.UserFacade
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "가족 초대 서비스")
@RequestMapping("/family")
@RestController
class FamilyController(
        private val userFacade: UserFacade,
        private val addService: AddService,
        private val familyListService: FamilyListService
) {
    @Operation(summary = "가족 초대 코드")
    @GetMapping("/code")
    fun code()
        = userFacade.getCurrentUser().id

    @Operation(summary = "가족 구성원 생성")
    @PostMapping
    fun add(@RequestBody addRequest: AddRequest)
        = addService.execute(addRequest)

    @Operation(summary = "가족 구성원 리스트 출력")
    @GetMapping
fun list(@RequestParam("code") code: String)
        = familyListService.execute(code)
}