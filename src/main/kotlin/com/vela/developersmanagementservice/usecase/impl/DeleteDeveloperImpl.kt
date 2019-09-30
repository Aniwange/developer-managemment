package com.vela.developersmanagementservice.usecase.impl

import com.vela.developersmanagementservice.infranstructure.gatewayImpl.DeveloperDomainGatewayImpl
import com.vela.developersmanagementservice.usecase.DeleteDeveloper
import javax.inject.Named

@Named
class DeleteDeveloperImpl(var developerDomainGatewayImpl: DeveloperDomainGatewayImpl) :DeleteDeveloper {
    override fun deleteDeveloper(id: Long): String {
        return  developerDomainGatewayImpl.deleteDeveloper(id)
    }
}