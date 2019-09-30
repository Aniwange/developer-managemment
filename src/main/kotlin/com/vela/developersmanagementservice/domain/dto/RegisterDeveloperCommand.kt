package com.vela.developersmanagementservice.domain.dto

import com.vela.developersmanagementservice.domain.dto.Enumeration.DeveloperCategory

class RegisterDeveloperCommand (var firstName: String,
                                var middleName: String,
                                var  lastName: String,
                                var  email: String,
                                var  phoneNumber: String,
                                var  category: DeveloperCategory)