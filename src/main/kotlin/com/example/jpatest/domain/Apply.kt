package com.example.jpatest.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
class Apply(
    userId: Long,
    desiredDates: List<LocalDate>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    val userId: Long = userId

    @ElementCollection
    @CollectionTable(name = "apply_desired_date", joinColumns = [JoinColumn(name = "apply_id")])
    var desiredDates: List<LocalDate> = desiredDates
        protected set

    fun updateDesiredDates(desiredDates: List<LocalDate>) {
        this.desiredDates = desiredDates
    }
}
