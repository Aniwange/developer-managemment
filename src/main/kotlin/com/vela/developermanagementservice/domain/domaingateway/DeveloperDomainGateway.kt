package com.vela.developermanagementservice.domain.domaingateway

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.dto.RegisterDeveloperCommand

interface DeveloperDomainGateway {
    fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain
    fun updateDeveloper(developerDomain: DeveloperDomain): DeveloperDomain
    fun deleteDeveloper(id: Long): String
    fun findDeveloper(id: Long) : DeveloperDomain
    fun getAllDevelopers(): MutableList<List<DeveloperDomain>>
}