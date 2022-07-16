package com.xingmingyue.filemanager.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

/**
 * 用户实体
 */
@Entity
@Table(name = "t_user")
data class User(
    // 用户ID
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = -1,
    // 用户名称
    val userName: String,
    // 用户账号
    val userAccount: String,
    // 用户密码
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) val userPassword: String
) : UserDetails {

    /**
     * 无参构造
     */
    constructor() : this(-1, "", "", "")

    /**
     * 返回授予用户的权限
     *
     * @return 权限列表
     */
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    /**
     * 返回用于验证用户的密码
     *
     * @return 密码
     */
    @JsonIgnore
    override fun getPassword(): String {
        return userPassword
    }

    /**
     * 返回用于验证用户的用户名
     *
     * @return 用户名
     */
    override fun getUsername(): String {
        return userAccount
    }

    /**
     * 用户未过期
     *
     * @return 用户未过期
     */
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    /**
     * 用户未锁定
     *
     * @return 用户未锁定
     */
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    /**
     * 密码未已过期
     *
     * @return 密码未已过期
     */
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    /**
     * 用户启用
     *
     * @return 用户启用
     */
    override fun isEnabled(): Boolean {
        return true
    }
}
