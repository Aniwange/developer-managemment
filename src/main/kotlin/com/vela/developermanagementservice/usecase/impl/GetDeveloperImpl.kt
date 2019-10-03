package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developermanagementservice.usecase.GetDeveloper
import javax.inject.Named


@Named
class  GetDeveloperImpl(val developerDomainGateway: DeveloperDomainGateway) : GetDeveloper {
    override fun getDeveloper(id: Long): DeveloperDomain {
        return  developerDomainGateway.findDeveloper(id)
    }
}