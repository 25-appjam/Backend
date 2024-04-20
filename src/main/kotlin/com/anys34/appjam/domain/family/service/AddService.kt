package com.anys34.appjam.domain.family.service

import com.anys34.appjam.domain.family.domain.repository.FamilyRepository
import com.anys34.appjam.domain.family.persentation.dto.req.AddRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddService(
        private val familyRepository: FamilyRepository
) {
    @Transactional
    fun execute(addRequest: AddRequest) {
        familyRepository.save(addRequest.toEntity())
    }
}