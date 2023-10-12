package team.iwfsg.fsg.domain.post.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import team.iwfsg.fsg.domain.post.persistence.repository.PostRepository

@DataJpaTest
class PostRepositoryTest : BehaviorSpec({
    Given("postRepository") {
        val postRepository = mockk<PostRepository>()
        When("create postRepository") {
            Then("postRepository is not null") {
                postRepository shouldNotBe null
            }
        }
    }
})