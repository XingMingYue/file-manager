package com.xingmingyue.filemanager.service

import com.xingmingyue.filemanager.core.BaseCrudService
import com.xingmingyue.filemanager.entity.User
import com.xingmingyue.filemanager.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * 用户服务
 */
@Service
class UserCrudService(
    val userRepository: UserRepository
) : BaseCrudService<User, Long>(userRepository), UserDetailsService {

    /**
     * 通过用户账号查询用户
     *
     * @param username 用户账号
     * @return 用户信息（不为null）
     * @throws UsernameNotFoundException 通过账号未查询到用户异常
     *
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUserAccount(username) ?: throw UsernameNotFoundException(username)
    }
}
