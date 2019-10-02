package com.vela.developermanagementservice.infrastructure.persistence.repository;


import com.vela.developermanagementservice.infrastructure.persistence.entities.PrivilegeDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegesDbEntityRepo extends JpaRepository<PrivilegeDbEntity, Long> {

}
