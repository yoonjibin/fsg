package team.iwfsg.fsg.domain.post.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import team.iwfsg.fsg.domain.post.persistence.repository.CategoryRepository

class CategoryRepositoryTest : BehaviorSpec({
    Given("categoryRepository") {
        val categoryRepository = mockk<CategoryRepository>()
        When("create postViewCountRepository") {
            Then("PostViewCountRepository is not null") {
                categoryRepository shouldNotBe null
            }
        }
    }
})