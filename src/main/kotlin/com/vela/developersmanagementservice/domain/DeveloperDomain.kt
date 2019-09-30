package com.vela.developersmanagementservice.domain

import com.vela.developersmanagementservice.domain.dto.Enumeration.DeveloperCategory

data class DeveloperDomain ( var id: Long,
                             var firstName: String,
                             var middleName: String,
                             var  lastName: String,
                             var  email: String,
                             var  phoneNumber: String,
                             var  category: DeveloperCategory)
