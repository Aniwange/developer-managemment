package com.vela.developermanagementservice.usecase

import com.vela.learnkoltlin.domain.dto.LoginResponseJSON

interface LoginUser {
    fun loginUser( email: String,  password : String) : LoginResponseJSON
}