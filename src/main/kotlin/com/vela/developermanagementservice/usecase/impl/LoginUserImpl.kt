package com.vela.developermanagementservice.usecase.impl

import com.vela.developermanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developermanagementservice.usecase.LoginUser
import com.vela.learnkoltlin.domain.dto.LoginResponseJSON
import javax.inject.Named


@Named
class LoginUserImpl(private var userDomainGateway: UserDomainGateway) : LoginUser {

    override fun loginUser(email: String, password: String): LoginResponseJSON {
        return  userDomainGateway.loginUser(email,password);
    }


}



