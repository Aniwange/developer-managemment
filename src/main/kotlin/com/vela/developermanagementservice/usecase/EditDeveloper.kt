package com.vela.developermanagementservice.usecase

import com.vela.developermanagementservice.domain.DeveloperDomain

interface EditDeveloper {
    fun editDeveloper(developerDomain: DeveloperDomain): DeveloperDomain
}