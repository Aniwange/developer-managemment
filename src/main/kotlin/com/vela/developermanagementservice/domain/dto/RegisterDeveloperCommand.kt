package com.vela.developermanagementservice.domain.dto

import com.vela.developermanagementservice.domain.dto.Enumeration.DeveloperCategory
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

class RegisterDeveloperCommand (
        @field:Valid
        @field:NotEmpty(message = "firstName should not be empty")
        val firstName:  String,

        @field:Valid
        @field:NotEmpty(message = "middleName should not be empty")
        val middleName: String,

        @field:Valid
        @field:NotEmpty(message = "lastName should not be empty")
        val  lastName:  String,

        @field:Valid
        @field:NotEmpty(message = "email should not be empty")
        @field:Email(message = "write a valid email")
        val  email:  String,

        @field:Valid
        @field:NotEmpty(message = "phoneNumber should not be empty")
        @field:Pattern(regexp = "(\\+61|0)[0-9]{9}")
        val  phoneNumber: String,

        @field:Valid
        @field:NotNull(message = "category should not be null")
        val  category: DeveloperCategory
   )