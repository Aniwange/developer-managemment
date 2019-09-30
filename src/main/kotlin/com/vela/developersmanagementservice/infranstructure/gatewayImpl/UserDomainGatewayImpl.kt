package com.vela.developersmanagementservice.infranstructure.gatewayImpl


import com.vela.developersmanagementservice.domain.UserDomain
import com.vela.developersmanagementservice.domain.domaingateway.UserDomainGateway
import com.vela.developersmanagementservice.domain.dto.RegisterUserCommand
import com.vela.developersmanagementservice.infranstructure.persistence.entities.Enumeration.Role
import com.vela.developersmanagementservice.infranstructure.persistence.entities.UserDbEntity
import com.vela.developersmanagementservice.infranstructure.persistence.repository.UserDbEntityRepository
import javax.inject.Named

@Named
class UserDomainGatewayImpl(var repo: UserDbEntityRepository) : UserDomainGateway {


    override fun registerUser(registerUserCommand: RegisterUserCommand): UserDomain {
        var role = if (Role.ADMIN.name == registerUserCommand.role) {
            Role.ADMIN;
        } else {
            Role.USER;
        }
       var  userDbEntity = UserDbEntity(firstName = registerUserCommand.firstName,
                email = registerUserCommand.email,
                middleName = registerUserCommand.middleName,
                lastName = registerUserCommand.lastName,
                password = registerUserCommand.password,
                role = role
                )
        repo.save(userDbEntity)

        return UserDomain(userDbEntity.id, userDbEntity.firstName, userDbEntity.middleName, userDbEntity.lastName, userDbEntity.email, userDbEntity.role.name)
    }
}