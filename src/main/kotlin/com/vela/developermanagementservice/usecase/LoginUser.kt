package com.vela.developermanagementservice.usecase

import com.vela.learnkoltlin.domain.dto.LoginResponseCommand

interface LoginUser {
    fun loginUser( email: String,  password : String) : LoginResponseCommand
}