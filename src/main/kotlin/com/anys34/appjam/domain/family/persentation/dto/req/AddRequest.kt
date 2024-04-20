package com.anys34.appjam.domain.family.persentation.dto.req

import com.anys34.appjam.domain.family.domain.Family


class AddRequest(
        val code: String,
        val name: String,
        val password: String
) {
    fun toEntity() = Family(
            code,
            name,
            password
    )
}