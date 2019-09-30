package com.vela.developersmanagementservice.infranstructure.presenter.controller

import com.vela.developersmanagementservice.domain.UserDomain
import com.vela.developersmanagementservice.domain.dto.RegisterUserCommand
import com.vela.developersmanagementservice.usecase.RegisterUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
class UserController(var registerUser: RegisterUser) {

    @PostMapping("/")
    fun registerUser(@RequestBody registerUserCommand: RegisterUserCommand): ResponseEntity<UserDomain>{
        return ResponseEntity.ok(registerUser.registerUser(registerUserCommand));
    }
}