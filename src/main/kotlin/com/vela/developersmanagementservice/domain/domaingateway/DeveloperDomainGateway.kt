package com.vela.developersmanagementservice.domain.domaingateway

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.dto.RegisterDeveloperCommand

interface DeveloperDomainGateway {
    fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain
    fun updateDeveloper(developerDomain: DeveloperDomain): DeveloperDomain
    fun deleteDeveloper(id: Long): String
    fun findDeveloper(id: Long) : DeveloperDomain
    fun getAllDevelopers(): MutableList<List<DeveloperDomain>>
}