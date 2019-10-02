package com.vela.developermanagementservice.infrastructure.persistence.repository

import com.vela.developermanagementservice.infrastructure.persistence.entities.DeveloperDbEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeveloperDbEntityRepository : JpaRepository<DeveloperDbEntity, Long> {

}