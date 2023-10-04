package team.iwfsg.fsg.global.security.principle

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity

class AuthDetails(
    private val user: UserJpaEntity
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = null

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.id.toString()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}