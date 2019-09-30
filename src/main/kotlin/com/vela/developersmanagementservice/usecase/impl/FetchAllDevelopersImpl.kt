package com.vela.developersmanagementservice.usecase.impl

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developersmanagementservice.usecase.FetchAllDevelopers
import javax.inject.Named

@Named
class FetchAllDevelopersImpl(var developerDomainGateway: DeveloperDomainGateway): FetchAllDevelopers{
    override fun fetchAllDevelopers(): MutableList<List<DeveloperDomain>> {
        return developerDomainGateway.getAllDevelopers()
    }
}