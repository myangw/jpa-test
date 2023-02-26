package com.example.jpatest.service

import com.example.jpatest.domain.Apply
import com.example.jpatest.domain.ApplyRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
@Transactional
class ApplyService(
    private val applyRepository: ApplyRepository
) {

    fun createApply(apply: Apply) {
        applyRepository.save(apply)
    }

    fun updateApply(id: Long, desiredDates: List<LocalDate>) {
        val apply = applyRepository.findById(id).orElseThrow()
        apply.updateDesiredDates(desiredDates)

        applyRepository.save(apply)
    }
}
