package com.vela.developermanagementservice.usecase

import com.vela.developermanagementservice.domain.DeveloperDomain

interface FetchAllDevelopers {
    fun fetchAllDevelopers(): MutableList<List<DeveloperDomain>>
}