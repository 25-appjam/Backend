package com.anys34.appjam.domain.family.service

import com.anys34.appjam.domain.family.domain.repository.FamilyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FamilyListService(
        private val familyRepository: FamilyRepository
) {
    @Transactional
    fun execute(code: String) = familyRepository.findByCode(code)
}