package com.vela.developermanagementservice.infrastructure.exception

import com.vela.developermanagementservice.infrastructure.security.ErrorResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class ControllerAdviceExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(BadArgumentException::class)
    fun handleGenericTextExceptions(e: BadArgumentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity<ErrorResponse>(ErrorResponse(LocalDateTime.now(), e.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleExceptions(e: BadArgumentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(LocalDateTime.now(), request.getDescription(true)), HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: BadArgumentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(LocalDateTime.now(), request.getDescription(true)), HttpStatus.NOT_ACCEPTABLE)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(ErrorResponse(LocalDateTime.now(), ex.bindingResult.toString()), HttpStatus.BAD_REQUEST)
    }
}