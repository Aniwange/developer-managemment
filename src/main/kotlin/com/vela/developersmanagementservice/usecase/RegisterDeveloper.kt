package com.vela.developersmanagementservice.usecase

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.dto.RegisterDeveloperCommand

interface RegisterDeveloper {
    fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain
}