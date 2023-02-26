package com.example.jpatest.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ApplyRepository : JpaRepository<Apply, Long> {
}
