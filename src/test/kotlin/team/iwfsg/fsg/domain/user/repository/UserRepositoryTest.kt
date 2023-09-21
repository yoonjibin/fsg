package team.iwfsg.fsg.domain.user.repository

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk

class UserRepositoryTest : StringSpec() {
    private val userRepository: UserRepository = mockk<UserRepository>()

    init {
        "userRepository is not null" {
            userRepository shouldNotBe null
        }
    }
}