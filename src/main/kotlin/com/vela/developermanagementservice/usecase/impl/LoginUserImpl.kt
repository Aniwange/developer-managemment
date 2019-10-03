package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developermanagementservice.usecase.LoginUser
import com.vela.learnkoltlin.domain.dto.LoginResponseCommand
import javax.inject.Named


@Named
class LoginUserImpl(private var userDomainGateway: UserDomainGateway) : LoginUser {

    override fun loginUser(email: String, password: String): LoginResponseCommand {
        return  userDomainGateway.loginUser(email,password);
    }


}



