package com.vela.developermanagementservice.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "privilege")
public class PrivilegeDbEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private  String name;

   public PrivilegeDbEntity(String name) {
      this.name = name;
   }
}
