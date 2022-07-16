package com.xingmingyue.filemanager.controller

import com.xingmingyue.filemanager.entity.User
import com.xingmingyue.filemanager.service.UserCrudService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 用户 Controller
 */
@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserCrudService
) {

    /**
     * 通过用户ID查询用户
     */
    @GetMapping("{userId}")
    fun findByUserId(@PathVariable userId: Long): User = userService.findById(userId).orElse(null)
}
