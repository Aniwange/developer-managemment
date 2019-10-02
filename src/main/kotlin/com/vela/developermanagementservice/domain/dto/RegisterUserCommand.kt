package com.vela.developermanagementservice.domain.dto

import com.vela.developermanagementservice.domain.dto.Enumeration.Role

data class RegisterUserCommand(
        var firstName: String,
        var middleName: String,
        var lastName: String,
        var email: String,
        var password: String,
        var role: Role

)