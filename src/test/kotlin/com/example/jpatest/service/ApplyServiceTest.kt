package com.example.jpatest.service

import com.example.jpatest.domain.Apply
import com.example.jpatest.domain.ApplyRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
internal class ApplyServiceTest {
    @Autowired
    private lateinit var applyRepository: ApplyRepository

    @Autowired
    private lateinit var applyService: ApplyService

    @BeforeEach
    fun clean_up() {
        applyRepository.deleteAllInBatch()
    }

    @Test
    fun `생성된 apply의 desired_date를 수정할 수 있다`() {
        // given
        val apply = Apply(userId = 1, desiredDates = mutableListOf(LocalDate.of(2023, 1, 1)))
        applyRepository.save(apply)

        // when
        val updatedDesiredDates = listOf(LocalDate.of(2023, 3, 1))
        applyService.updateApply(apply.id, updatedDesiredDates)

        // then
        val updatedApply = applyRepository.findById(apply.id).orElseThrow()
        assertEquals(updatedApply.id, apply.id)
    }

}
