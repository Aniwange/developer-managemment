package com.vela.developermanagementservice.domain.domaingateway

import com.vela.developermanagementservice.domain.UserDomain
import com.vela.developermanagementservice.domain.dto.RegisterUserCommand
import com.vela.learnkoltlin.domain.dto.LoginResponseCommand


interface UserDomainGateway {
    fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain;
    fun loginUser(email: String, password: String ): LoginResponseCommand;
}