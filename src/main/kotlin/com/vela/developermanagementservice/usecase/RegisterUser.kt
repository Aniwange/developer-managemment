package com.vela.developermanagementservice.usecase

import com.vela.developermanagementservice.domain.UserDomain
import com.vela.developermanagementservice.domain.dto.RegisterUserCommand


interface RegisterUser{
    fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain
}

