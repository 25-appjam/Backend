package com.anys34.appjam.global.security.jwt.exception

import com.anys34.appjam.global.config.error.exception.BusinessException
import com.anys34.appjam.global.config.error.exception.ErrorCode

object ExpiredJwtException: BusinessException(ErrorCode.EXPIRED_JWT)