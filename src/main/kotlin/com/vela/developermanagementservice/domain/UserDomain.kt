package com.vela.developermanagementservice.domain

data class UserDomain(
        var id: Long,
        var firstName: String,
        var middleName: String,
        var  lastName: String,
        var  email: String,
        var  role: String
)
