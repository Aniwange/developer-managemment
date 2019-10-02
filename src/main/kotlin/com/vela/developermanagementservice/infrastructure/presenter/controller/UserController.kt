package com.vela.developermanagementservice.infrastructure.presenter.controller

import com.vela.developermanagementservice.domain.UserDomain
import com.vela.developermanagementservice.domain.dto.LoginUserCommand
import com.vela.developermanagementservice.domain.dto.RegisterUserCommand
import com.vela.developermanagementservice.usecase.LoginUser
import com.vela.developermanagementservice.usecase.RegisterUser
import com.vela.learnkoltlin.domain.dto.LoginResponseJSON
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/user")
class UserController(var registerUser: RegisterUser, var loginUser: LoginUser) {

    @PostMapping("/")
    fun registerUser(@RequestBody registerUserCommand: RegisterUserCommand): ResponseEntity<UserDomain>{
        return ResponseEntity.ok(registerUser.registerUser(registerUserCommand));
    }
    @PostMapping(value = "/login")
    @ResponseBody
    internal fun login(@Valid @RequestBody loginRequest: LoginUserCommand): ResponseEntity<LoginResponseJSON> {
        return ResponseEntity.ok(loginUser.loginUser(loginRequest.username, loginRequest.password) )
    }
}