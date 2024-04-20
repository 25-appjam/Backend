package com.anys34.appjam.domain.user.presentation

import com.anys34.appjam.domain.user.facade.UserFacade
import com.anys34.appjam.domain.user.presentation.dto.req.LoginRequest
import com.anys34.appjam.domain.user.presentation.dto.req.SigninRequest
import com.anys34.appjam.domain.user.service.AuthService
import com.anys34.appjam.domain.user.service.SigninService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "auth API")
@RequestMapping("/auth")
@RestController
class AuthController(
        private val signinService: SigninService,
        private val authService: AuthService,
        private val userFacade: UserFacade
) {
    @Operation(summary = "회원가입")
    @PostMapping("/register")
    fun signin(@RequestBody @Valid signinRequest: SigninRequest)
        = signinService.execute(signinRequest)

    @Operation(summary = "token 발급")
    @PostMapping
    fun login(@RequestBody @Valid loginRequest: LoginRequest)
        = authService.execute(loginRequest)

    @Operation(summary = "유저 정보 조회")
    @GetMapping
    fun profile()
        = userFacade.getCurrentUser()
}