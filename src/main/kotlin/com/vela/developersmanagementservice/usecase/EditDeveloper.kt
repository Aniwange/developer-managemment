package com.vela.developersmanagementservice.usecase

import com.vela.developersmanagementservice.domain.DeveloperDomain

interface EditDeveloper {
    fun editDeveloper(developerDomain: DeveloperDomain): DeveloperDomain
}