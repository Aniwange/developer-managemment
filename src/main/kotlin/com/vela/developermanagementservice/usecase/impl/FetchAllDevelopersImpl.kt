package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developermanagementservice.usecase.FetchAllDevelopers
import javax.inject.Named

@Named
class FetchAllDevelopersImpl(var developerDomainGateway: DeveloperDomainGateway): FetchAllDevelopers{
    override fun fetchAllDevelopers(): MutableList<List<DeveloperDomain>> {
        return developerDomainGateway.getAllDevelopers()
    }
}