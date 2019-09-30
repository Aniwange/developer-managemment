package com.vela.developersmanagementservice.usecase

import com.vela.developersmanagementservice.domain.DeveloperDomain

interface FetchAllDevelopers {
    fun fetchAllDevelopers(): MutableList<List<DeveloperDomain>>
}