package com.vela.developermanagementservice.infrastructure.persistence.entities


import com.vela.developermanagementservice.domain.dto.Enumeration.Role
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
        var role: Role,
        @ManyToOne
        @JoinColumn(name = "privilege_id")
        internal var privilege: PrivilegeDbEntity? = null

)