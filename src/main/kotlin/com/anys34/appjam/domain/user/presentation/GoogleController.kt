package com.anys34.appjam.domain.user.presentation

import com.anys34.appjam.domain.auth.presentation.dto.req.AccessTokenRequest
import com.anys34.appjam.domain.user.service.GoogleAuthService
import com.anys34.appjam.domain.user.service.GoogleLinkService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "google API")
@RequestMapping("/google")
@RestController
class GoogleController(
        private val googleLinkService: GoogleLinkService,
        private val googleAuthService: GoogleAuthService,
) {
    @Operation(summary = "구글 로그인 링크")
    @GetMapping
    fun getGoogleAuthLink() = googleLinkService.execute()

    @Operation(summary = "token 발급")
    @PostMapping
    fun login(@RequestBody @Valid accessTokenRequest: AccessTokenRequest)
        = googleAuthService.execute(accessTokenRequest.accessToken)

}