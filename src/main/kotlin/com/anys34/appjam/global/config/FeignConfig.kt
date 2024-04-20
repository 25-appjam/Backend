package com.anys34.appjam.global.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.anys34.appjam.global.feign"])
@Configuration
class FeignConfig {
}