package com.vela.developermanagementservice.domain.dto

import com.vela.developermanagementservice.domain.dto.Enumeration.Role
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RegisterUserCommand(
        @field:Valid
        @field:NotEmpty(message = "firstName should not be empty")
        val firstName: String,

        @field:Valid
        @field:NotEmpty(message = "middleName should not be empty")
        val middleName: String,

        @field:Valid
        @field:NotEmpty(message = "lastName should not be empty")
        val lastName: String,

        @field:Valid
        @field: Email(message = "write a valid in email here")
        val email: String,

        @field:Valid
        @field:NotEmpty(message = "password should not be empty")
        val password: String,

        @field:Valid
        @field:NotNull(message = "role should not be empty")
        val role: Role
)