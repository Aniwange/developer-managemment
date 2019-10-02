package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developermanagementservice.usecase.EditDeveloper
import javax.inject.Named

@Named
class EditDeveloperImpl(var developerDomainGateway: DeveloperDomainGateway): EditDeveloper{
    override fun editDeveloper(developerDomain: DeveloperDomain): DeveloperDomain {
        return developerDomainGateway.updateDeveloper(developerDomain);
    }

}