package com.vela.developermanagementservice.usecase

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.dto.RegisterDeveloperCommand

interface RegisterDeveloper {
    fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain
}