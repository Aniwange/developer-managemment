package com.vela.developersmanagementservice.domain.domaingateway

import com.vela.developersmanagementservice.domain.UserDomain
import com.vela.developersmanagementservice.domain.dto.RegisterUserCommand


interface UserDomainGateway {
    fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain;
    //fun loginUser(email: String, password: String): UserDomain;
}