package com.vela.developermanagementservice.infrastructure.presenter.controller

import com.vela.developermanagementservice.domain.DeveloperDomain
import com.vela.developermanagementservice.domain.dto.RegisterDeveloperCommand
import com.vela.developermanagementservice.usecase.*
import lombok.NoArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@NoArgsConstructor
@RequestMapping("api/developer")
class DeveloperController(
        var deleteDeveloper: DeleteDeveloper,
        var editDeveloper: EditDeveloper,
        var fetchAllDevelopers: FetchAllDevelopers,
        var registerDeveloper: RegisterDeveloper,
        var getDeveloper: GetDeveloper) {

    @PostMapping("/")
    fun registerDeveloper(@RequestHeader("Authorization")  authorization: String,  @Valid @RequestBody registerDeveloperCommand: RegisterDeveloperCommand) :ResponseEntity<DeveloperDomain>{
       return ResponseEntity.ok(registerDeveloper.registerDeveloper(registerDeveloperCommand));
    }

    @PutMapping("/edit")
    fun editDeveloper(@RequestHeader("Authorization")  authorization: String, @RequestBody developerDomain: DeveloperDomain) : ResponseEntity<DeveloperDomain>{
        return ResponseEntity.ok(editDeveloper.editDeveloper(developerDomain))

    }
    @GetMapping("/delete/{id}")
    fun deleteDeveloper(@RequestHeader("Authorization")  authorization: String, @RequestParam id: Long) :ResponseEntity<String>{
     return ResponseEntity.ok(deleteDeveloper.deleteDeveloper(id))
    }

    @GetMapping(value = "/")
    fun fetchAllDevelopers(@RequestHeader("Authorization")  authorization: String) : ResponseEntity<MutableList<List<DeveloperDomain>>> {
        return ResponseEntity.ok(fetchAllDevelopers.fetchAllDevelopers())

    }

    @GetMapping("/{id}")
    fun getDeveloper(@RequestHeader("Authorization")  authorization: String, @RequestParam id: Long) :ResponseEntity<DeveloperDomain>{
        return ResponseEntity.ok(getDeveloper.getDeveloper(id))
    }

}