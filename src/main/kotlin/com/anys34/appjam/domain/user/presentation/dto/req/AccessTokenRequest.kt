package com.anys34.appjam.domain.auth.presentation.dto.req

import jakarta.validation.constraints.NotNull

class AccessTokenRequest(
        @NotNull
        val accessToken: String
)