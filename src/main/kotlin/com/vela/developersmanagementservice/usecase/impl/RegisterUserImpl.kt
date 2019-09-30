package com.vela.developersmanagementservice.usecase.impl


import com.vela.developersmanagementservice.domain.UserDomain
import com.vela.developersmanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developersmanagementservice.domain.dto.RegisterUserCommand
import com.vela.developersmanagementservice.usecase.RegisterUser
import javax.inject.Named


@Named
class RegisterUserImpl(var userDomainGateway: UserDomainGateway) : RegisterUser {

    override fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain {
        return  userDomainGateway.registerUser(registerUserCommand)
    }

}