package com.auth.authktltuto.controllers

import com.auth.authktltuto.dtos.LoginDTO
import com.auth.authktltuto.dtos.Message
import com.auth.authktltuto.dtos.RegisterDTO
import com.auth.authktltuto.models.User
import com.auth.authktltuto.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api")

class AuthController(private val userService: UserService) {

    @PostMapping("register")

    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User>{
        val user = User()
        user.name = body.name
        user.email = body.email
        user.password = body.password
        return ResponseEntity.ok(this.userService.saveUser(user))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any>{
        val user = this.userService.findUserByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("User not found!"))
        if (!user.comparePassword(body.password)){
            return ResponseEntity.badRequest().body(Message("password not valide!"))
        }

        val issuer = user.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS256, "secret").compact()

        val cookie = Cookie("jwt",jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        //return ResponseEntity.ok(user)
        //return ResponseEntity.ok(jwt)
        return ResponseEntity.ok(Message("Success!"))
    }

    @GetMapping("user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any>{
        try {
            if (jwt == null) return ResponseEntity.status(401).body(Message("Unauthenticated"))
            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            return ResponseEntity.ok(this.userService.userById(body.issuer.toInt()))
        } catch (ex: Exception){
            return ResponseEntity.status(401).body(Message("Unauthenticated"))
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any>{
            var cookie = Cookie("jwt", "")
            cookie.maxAge = 0
        response.addCookie(cookie)
        return ResponseEntity.ok(Message("Success"))
    }

}