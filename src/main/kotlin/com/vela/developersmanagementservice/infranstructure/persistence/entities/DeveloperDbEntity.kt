package com.vela.developersmanagementservice.infranstructure.persistence.entities

import com.vela.developersmanagementservice.domain.dto.Enumeration.DeveloperCategory
import javax.persistence.*

@Entity
@Table(name = "developers")
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