package com.vela.developermanagementservice.domain

import com.vela.developermanagementservice.domain.dto.Enumeration.DeveloperCategory

data class DeveloperDomain ( var id: Long,
                             var firstName: String,
                             var middleName: String,
                             var  lastName: String,
                             var  email: String,
                             var  phoneNumber: String,
                             var  category: DeveloperCategory)
