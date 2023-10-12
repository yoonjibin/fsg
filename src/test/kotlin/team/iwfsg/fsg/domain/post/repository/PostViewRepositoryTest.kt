package team.iwfsg.fsg.domain.post.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import team.iwfsg.fsg.domain.post.persistence.repository.PostViewCountRepository

class PostViewRepositoryTest : BehaviorSpec({
    Given("postViewCountRepository") {
        val postViewCountRepository = mockk<PostViewCountRepository>()
        When("create postViewCountRepository") {
            Then("PostViewCountRepository is not null") {
                postViewCountRepository shouldNotBe null
            }
        }
    }
})