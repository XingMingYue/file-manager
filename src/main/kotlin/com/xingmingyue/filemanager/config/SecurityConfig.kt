package com.xingmingyue.filemanager.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

/**
 * Security 配置
 */
@EnableWebSecurity
class SecurityConfig {

    /**
     * 配置
     */
    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            // 禁用CSRF
            .csrf().disable()
            // 允许嵌套
            .headers().frameOptions().disable().and()
            // 关闭Session
            .sessionManagement().disable()
            // 登录后任何请求都可以访问
            .authorizeHttpRequests().anyRequest().authenticated().and()
            .httpBasic(withDefaults())
            .formLogin(withDefaults())
        return http.build()
    }

    /**
     * 密码加密解密
     */
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}
