package com.vela.developersmanagementservice.infranstructure.persistence.repository

import com.vela.developersmanagementservice.infranstructure.persistence.entities.UserDbEntity
import org.springframework.data.jpa.repository.JpaRepository


interface UserDbEntityRepository : JpaRepository<UserDbEntity, Long> {
    fun findByEmail(email: String) : UserDbEntity
}