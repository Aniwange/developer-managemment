package com.vela.developersmanagementservice.infranstructure.persistence.repository

import com.vela.developersmanagementservice.infranstructure.persistence.entities.DeveloperDbEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeveloperDbEntityRepository : JpaRepository<DeveloperDbEntity, Long> {

}