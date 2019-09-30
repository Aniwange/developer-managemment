package com.vela.learnkoltlin.usecase

import com.vela.learnkoltlin.domain.UserDomain

interface LoginUser {
    fun loginUser( email: String,  password : String) : UserDomain
}