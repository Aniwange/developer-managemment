package com.vela.learnkoltlin.domain.dto

data class RegisterUserCommand(
        var firstName: String,
        var middleName: String,
        var lastName: String,
        var email: String,
        var password: String,
        var role: String

)