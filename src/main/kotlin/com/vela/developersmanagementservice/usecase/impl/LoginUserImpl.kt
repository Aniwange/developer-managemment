package com.vela.developersmanagementservice.usecase.impl

import com.vela.learnkoltlin.domain.UserDomain
import com.vela.learnkoltlin.domain.domaingateway.UserDomainGateway
import com.vela.learnkoltlin.usecase.LoginUser

class LoginUserImpl(private var userDomainGateway: UserDomainGateway) : LoginUser {
    override fun loginUser(email: String, password: String): UserDomain {
        return userDomainGateway.loginUser(email, password)
    }
}



