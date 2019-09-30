package com.vela.developersmanagementservice.usecase.impl

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.dto.RegisterDeveloperCommand
import com.vela.developersmanagementservice.infranstructure.gatewayImpl.DeveloperDomainGatewayImpl
import com.vela.developersmanagementservice.usecase.RegisterDeveloper
import javax.inject.Named

@Named
class RegisterDeveloperImpl(var developerDomainGatewayImpl: DeveloperDomainGatewayImpl) : RegisterDeveloper {
    override fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain {
        return developerDomainGatewayImpl.registerDeveloper(registerDeveloperCommand)
    }
}