package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.infrastructure.gatewayImpl.DeveloperDomainGatewayImpl
import com.vela.developermanagementservice.usecase.DeleteDeveloper
import javax.inject.Named

@Named
class DeleteDeveloperImpl(var developerDomainGatewayImpl: DeveloperDomainGatewayImpl) :DeleteDeveloper {
    override fun deleteDeveloper(id: Long): String {
        return  developerDomainGatewayImpl.deleteDeveloper(id)
    }
}