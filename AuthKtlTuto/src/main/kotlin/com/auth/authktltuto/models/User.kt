package com.auth.authktltuto.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column
    var name = ""

    @Column(unique = true)
    var email = ""

    @Column
    var password = ""
        @JsonIgnore
    get() = field
    set(value){
        val passWordEncoder = BCryptPasswordEncoder()
        field=passWordEncoder.encode(value)
    }

    fun comparePassword(password:String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }

}