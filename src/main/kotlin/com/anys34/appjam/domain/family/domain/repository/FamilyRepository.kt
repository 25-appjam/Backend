package com.anys34.appjam.domain.family.domain.repository

import com.anys34.appjam.domain.family.domain.Family
import org.springframework.data.jpa.repository.JpaRepository

interface FamilyRepository: JpaRepository<Family, Long> {
    fun findByCode(code: String): List<Family>?
}