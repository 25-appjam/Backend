package com.anys34.appjam.global.config.error.exception

abstract class BusinessException(
        val errorCode: ErrorCode
): RuntimeException()