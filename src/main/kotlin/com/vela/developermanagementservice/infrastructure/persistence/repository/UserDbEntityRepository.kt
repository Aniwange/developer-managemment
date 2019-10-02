package com.vela.developermanagementservice.infrastructure.persistence.repository

import com.vela.developermanagementservice.infrastructure.persistence.entities.UserDbEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserDbEntityRepository : JpaRepository<UserDbEntity, Long> {
    fun findByEmail(email: String) : UserDbEntity
}