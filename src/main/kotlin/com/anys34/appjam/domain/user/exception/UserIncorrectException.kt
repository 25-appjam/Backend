package com.anys34.appjam.domain.user.exception

import com.anys34.appjam.global.config.error.exception.BusinessException
import com.anys34.appjam.global.config.error.exception.ErrorCode

object UserIncorrectException: BusinessException(ErrorCode.USER_INCORRECT)