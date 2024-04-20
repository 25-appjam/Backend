package com.anys34.appjam.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
data class JwtProperties(
        val accessTime: Long,
        val prefix: String,
        val header: String,
        val secretKey: String
) {
}