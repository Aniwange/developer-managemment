package com.vela.developersmanagementservice.usecase

import com.vela.developersmanagementservice.domain.UserDomain
import com.vela.developersmanagementservice.domain.dto.RegisterUserCommand


interface RegisterUser{
    fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain
}

