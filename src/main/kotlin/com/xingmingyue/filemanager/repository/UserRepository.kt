package com.xingmingyue.filemanager.repository

import com.xingmingyue.filemanager.entity.User
import org.springframework.data.repository.CrudRepository

/**
 * 用户资源
 */
interface UserRepository : CrudRepository<User, Long> {

    /**
     * 通过账号查询用户
     *
     * @param userAccount 用户账号
     * @return 用户信息
     */
    fun findByUserAccount(userAccount: String): User?

}
