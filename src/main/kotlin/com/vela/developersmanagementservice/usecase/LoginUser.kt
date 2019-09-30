package com.vela.learnkoltlin.usecase

import com.vela.developersmanagementservice.domain.UserDomain


interface LoginUser {
    fun loginUser( email: String,  password : String) : UserDomain
}