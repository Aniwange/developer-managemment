package com.vela.learnkoltlin.usecase

import com.vela.learnkoltlin.domain.UserDomain
import com.vela.learnkoltlin.domain.dto.RegisterUserCommand


interface RegisterUser{
    fun registerUser(registerUserCommand: RegisterUserCommand):UserDomain
}

