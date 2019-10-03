package com.vela.developermanagementservice.domain.dto

import javax.validation.Valid
import javax.validation.constraints.NotEmpty

data class LoginUserCommand(
        @field:Valid
        @field:NotEmpty(message = "username should not be empty")
        var username : String,

        @field:Valid
        @field:NotEmpty(message = "username should not be empty")
        var password: String
        )