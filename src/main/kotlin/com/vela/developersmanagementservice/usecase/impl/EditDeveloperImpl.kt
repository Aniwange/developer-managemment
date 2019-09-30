package com.vela.developersmanagementservice.usecase.impl

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developersmanagementservice.usecase.EditDeveloper
import javax.inject.Named

@Named
class EditDeveloperImpl(var developerDomainGateway: DeveloperDomainGateway): EditDeveloper{
    override fun editDeveloper(developerDomain: DeveloperDomain): DeveloperDomain {
        return developerDomainGateway.updateDeveloper(developerDomain);
    }

}