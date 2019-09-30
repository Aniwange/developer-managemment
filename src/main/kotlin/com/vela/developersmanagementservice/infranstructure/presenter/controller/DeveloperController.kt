package com.vela.developersmanagementservice.infranstructure.presenter.controller

import com.vela.developersmanagementservice.domain.DeveloperDomain
import com.vela.developersmanagementservice.domain.dto.RegisterDeveloperCommand
import com.vela.developersmanagementservice.usecase.DeleteDeveloper
import com.vela.developersmanagementservice.usecase.EditDeveloper
import com.vela.developersmanagementservice.usecase.FetchAllDevelopers
import com.vela.developersmanagementservice.usecase.RegisterDeveloper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/developer")
class DeveloperController(var deleteDeveloper: DeleteDeveloper,
                          var editDeveloper: EditDeveloper,
                          var fetchAllDevelopers: FetchAllDevelopers,
                          var registerDeveloper: RegisterDeveloper) {

    @PostMapping("/")
    fun registerDeveloper(@RequestBody registerDeveloperCommand: RegisterDeveloperCommand) :ResponseEntity<DeveloperDomain>{
       return ResponseEntity.ok(registerDeveloper.registerDeveloper(registerDeveloperCommand));
    }

    @PostMapping("/edit")
    fun editDeveloper(@RequestBody developerDomain: DeveloperDomain) : ResponseEntity<DeveloperDomain>{
        return ResponseEntity.ok(editDeveloper.editDeveloper(developerDomain))

    }
    @GetMapping("/delete/{id}")
    fun deleteDeveloper(@RequestParam id: Long) :ResponseEntity<String>{
     return ResponseEntity.ok(deleteDeveloper.deleteDeveloper(id))
    }

    @GetMapping(value = "/")
    fun fetchAllDevelopers() : ResponseEntity<MutableList<List<DeveloperDomain>>> {
        return ResponseEntity.ok(fetchAllDevelopers.fetchAllDevelopers())

    }
}