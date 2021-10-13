package com.auth.authktltuto.services

import com.auth.authktltuto.models.User
import com.auth.authktltuto.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun saveUser(user: User): User{
        return this.userRepository.save(user)
    }

    fun findUserByEmail(email: String): User?{
        return this.userRepository.findUserByEmail(email)
    }

    fun userById(id: Int): User{
        return this.userRepository.getById(id)
    }
}