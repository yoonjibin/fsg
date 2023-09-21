package team.iwfsg.fsg.domain.user.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository

@DataJpaTest
class UserRepositoryTest : BehaviorSpec({
      Given("UserRepository") {
          val userRepository = mockk<UserRepository>()
          When("Create UserRepository") {
              Then("UserRepository is Not null") {
                  userRepository shouldNotBe null
              }
          }
      }
})