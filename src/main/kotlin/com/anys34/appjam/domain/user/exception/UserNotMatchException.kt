package com.anys34.appjam.domain.user.exception

import com.anys34.appjam.global.config.error.exception.BusinessException
import com.anys34.appjam.global.config.error.exception.ErrorCode

object UserNotMatchException: BusinessException(ErrorCode.USER_NOT_MATCH)