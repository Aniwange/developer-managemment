package com.vela.developermanagementservice.infrastructure.gatewayImpl

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.domaingateway.DeveloperDomainGateway
import com.vela.developermanagementservice.domain.dto.RegisterDeveloperCommand
import com.vela.developermanagementservice.infrastructure.persistence.entities.DeveloperDbEntity
import com.vela.developermanagementservice.infrastructure.persistence.repository.DeveloperDbEntityRepository
import javax.inject.Named

@Named
class DeveloperDomainGatewayImpl(var developerDbEntityRepository: DeveloperDbEntityRepository) : DeveloperDomainGateway {

    override fun getAllDevelopers(): MutableList<List<DeveloperDomain>> {
        var developerDbEntityList = developerDbEntityRepository.findAll();
        var developerDomains = developerDbEntityList.map {e-> DeveloperDomain(e.id, e.firstName, e.middleName, e.lastName,
                e.email, e.phoneNumber, e.category)  }

        return mutableListOf(developerDomains);
    }



    override fun registerDeveloper(registerDeveloperCommand: RegisterDeveloperCommand): DeveloperDomain {
        var developerDbEntity = DeveloperDbEntity(
                firstName = registerDeveloperCommand.firstName,
                lastName = registerDeveloperCommand.lastName,
                middleName = registerDeveloperCommand.middleName,
                email = registerDeveloperCommand.email,
                phoneNumber = registerDeveloperCommand.phoneNumber,
                category = registerDeveloperCommand.category
        )
        developerDbEntityRepository.save(developerDbEntity)
        return DeveloperDomain(developerDbEntity.id, developerDbEntity.firstName, developerDbEntity.middleName, developerDbEntity.lastName,
                developerDbEntity.email, developerDbEntity.phoneNumber, developerDbEntity.category)
    }


    override fun updateDeveloper(developerDomain: DeveloperDomain): DeveloperDomain {
        var developerDbEntityOptional = developerDbEntityRepository.findById(developerDomain.id)
        if (!developerDbEntityOptional.isPresent) {
            throw IllegalArgumentException("Developer not found")
        }
        var developerDbEntity = developerDbEntityOptional.get()
        developerDbEntity.email = developerDomain.email;
        developerDbEntity.firstName = developerDomain.firstName;
        developerDbEntity.lastName = developerDomain.lastName;
        developerDbEntity.middleName = developerDomain.middleName;
        developerDbEntity.category = developerDomain.category;
        developerDbEntity.phoneNumber = developerDomain.phoneNumber;
        developerDbEntityRepository.save(developerDbEntity)
        return DeveloperDomain(developerDbEntity.id, developerDbEntity.firstName, developerDbEntity.middleName, developerDbEntity.lastName,
                developerDbEntity.email, developerDbEntity.phoneNumber, developerDbEntity.category)


    }


    override fun deleteDeveloper(id: Long): String {
        var developerDbEntityOptional = developerDbEntityRepository.findById(id)
        if (!developerDbEntityOptional.isPresent) {
            throw IllegalArgumentException("Developer not found")
        }
        developerDbEntityRepository.delete(developerDbEntityOptional.get())
        return "developer with " + developerDbEntityOptional.get().id + " id has been deleted";
    }


    override fun findDeveloper(id: Long): DeveloperDomain {
        var developerDbEntityOptional = developerDbEntityRepository.findById(id)
        if (!developerDbEntityOptional.isPresent) {
            throw IllegalArgumentException("Developer not found")
        }
        var developerDbEntity = developerDbEntityOptional.get()
        return DeveloperDomain(developerDbEntity.id, developerDbEntity.firstName, developerDbEntity.middleName, developerDbEntity.lastName,
                developerDbEntity.email, developerDbEntity.phoneNumber, developerDbEntity.category)
    }


}