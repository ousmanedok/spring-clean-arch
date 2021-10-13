package com.auth.authktltuto.repositories

import com.auth.authktltuto.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findUserByEmail(email: String): User?
}