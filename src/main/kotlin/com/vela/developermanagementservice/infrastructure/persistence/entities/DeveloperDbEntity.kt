package com.vela.developermanagementservice.infrastructure.persistence.entities

import com.vela.developermanagementservice.domain.dto.Enumeration.DeveloperCategory
import javax.persistence.*

@Entity
@Table(name = "developer")
class DeveloperDbEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String,
        var middleName: String,
        var  lastName: String,
        var  email: String,
        var  phoneNumber: String,
        @Enumerated(EnumType.STRING)
        var  category: DeveloperCategory
)