package com.anys34.appjam.global.security.jwt

import com.anys34.appjam.global.config.properties.JwtProperties
import com.anys34.appjam.global.security.jwt.exception.ExpiredJwtException
import com.anys34.appjam.global.security.jwt.exception.InvalidJwtException
import com.anys34.appjam.global.security.principal.UserDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val authDetailsService: UserDetailsService,
) {
    private val ACCESS_KEY: String = "access_token"

    fun createAccessToken(email: String): String
        = createToken(email, ACCESS_KEY, jwtProperties.accessTime)

    fun createToken(email: String, type: String, time: Long): String {
        val now = Date()
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                .setSubject(email)
                .setHeaderParam("typ", type)
                .setIssuedAt(now)
                .setExpiration(Date(now.time + time))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authorization")
        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "")
        }
        return null
    }

    fun authorization(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getTokenSubject(subject: String):String
        = getTokenBody(subject).body.subject

    fun getTokenBody(token: String): Jws<Claims> {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.secretKey)
                    .parseClaimsJws(token)
        } catch (e: io.jsonwebtoken.ExpiredJwtException) {
            throw ExpiredJwtException
        } catch (e: Exception) {
            throw InvalidJwtException
        }
    }
}