package com.vela.developermanagementservice.usecase.impl


import com.vela.developermanagementservice.domain.UserDomain
import com.vela.developermanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developermanagementservice.domain.dto.RegisterUserCommand
import com.vela.developermanagementservice.usecase.RegisterUser
import javax.inject.Named


@Named
class RegisterUserImpl(var userDomainGateway: UserDomainGateway) : RegisterUser {

    override fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain {
        return  userDomainGateway.registerUser(registerUserCommand)
    }

}