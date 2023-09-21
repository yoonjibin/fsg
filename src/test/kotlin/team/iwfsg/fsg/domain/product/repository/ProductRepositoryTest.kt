package team.iwfsg.fsg.domain.product.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import team.iwfsg.fsg.domain.product.persistence.repository.ProductRepository

@DataJpaTest
class ProductRepositoryTest : BehaviorSpec({
    Given("productRepository") {
        val productRepository = mockk<ProductRepository>()
        When("create ProductRepository") {
            Then("ProductRepository is not null") {
                productRepository shouldNotBe null
            }
        }
    }
})