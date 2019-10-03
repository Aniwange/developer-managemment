package com.vela.developermanagementservice.usecase

import com.vela.developermanagementservice.domain.DeveloperDomain

interface GetDeveloper {
    fun getDeveloper(id: Long): DeveloperDomain
}