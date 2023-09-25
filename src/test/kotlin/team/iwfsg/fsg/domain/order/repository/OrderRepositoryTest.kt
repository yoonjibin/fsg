package team.iwfsg.fsg.domain.order.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import team.iwfsg.fsg.domain.order.persistence.repository.OrderRepository

@DataJpaTest
class OrderRepositoryTest : BehaviorSpec({
    Given("orderRepository") {
        val orderRepository = mockk<OrderRepository>()
           When("Create OrderRepository") {
               Then("OrderRepository is not null") {
                   orderRepository shouldNotBe null
               }
           }
    }
})