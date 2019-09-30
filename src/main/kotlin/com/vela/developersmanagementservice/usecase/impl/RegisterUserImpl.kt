package com.vela.learnkoltlin.usecase.impl

import com.vela.learnkoltlin.domain.UserDomain
import com.vela.learnkoltlin.domain.domaingateway.UserDomainGateway
import com.vela.learnkoltlin.domain.dto.RegisterUserCommand
import com.vela.learnkoltlin.usecase.RegisterUser
import javax.inject.Named


@Named
class RegisterUserImpl(var userDomainGateway: UserDomainGateway) : RegisterUser {

    override fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain {
        return  userDomainGateway.registerUser(registerUserCommand)
    }

}