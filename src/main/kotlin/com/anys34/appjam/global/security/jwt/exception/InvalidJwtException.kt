package com.anys34.appjam.global.security.jwt.exception

import com.anys34.appjam.global.config.error.exception.BusinessException
import com.anys34.appjam.global.config.error.exception.ErrorCode

object InvalidJwtException: BusinessException(ErrorCode.INVALID_JWT)