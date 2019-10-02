package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.dto.RegisterDeveloperCommand
import com.vela.developermanagementservice.infrastructure.gatewayImpl.DeveloperDomainGatewayImpl
import com.vela.developermanagementservice.usecase.RegisterDeveloper
import javax.inject.Named

@Named
class RegisterDeveloperImpl(var developerDomainGatewayImpl: DeveloperDomainGatewayImpl) : RegisterDeveloper {
    override fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain {
        return developerDomainGatewayImpl.registerDeveloper(registerDeveloperCommand)
    }
}