package com.vela.developermanagementservice.domain.dto

import com.vela.developermanagementservice.infrastructure.persistence.entities.UserDbEntity


data class LoginResponse(
        val access_token: String? = null,
        val token_type: String? = null,
        val refresh_token: String? = null,
        val expires_in: Int? = null,
        val scope: String? = null,
        val user: UserDbEntity? = null
)

