package com.vela.learnkoltlin.domain.domaingateway

import com.vela.learnkoltlin.domain.UserDomain
import com.vela.learnkoltlin.domain.dto.RegisterUserCommand

interface UserDomainGateway {
    fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain;
    fun loginUser(email: String, password: String): UserDomain;
}