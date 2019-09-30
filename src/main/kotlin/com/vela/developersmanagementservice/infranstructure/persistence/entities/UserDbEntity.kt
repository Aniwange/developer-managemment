package com.vela.developersmanagementservice.infranstructure.persistence.entities


import com.vela.developersmanagementservice.infranstructure.persistence.entities.Enumeration.Role
import javax.persistence.*


@Entity
@Table(name = "account")
class UserDbEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long=0,
        var firstName: String,
        var middleName: String,
        var lastName: String,
        var email: String,
        var password: String,
        @Enumerated(EnumType.STRING)
        var role: Role
)