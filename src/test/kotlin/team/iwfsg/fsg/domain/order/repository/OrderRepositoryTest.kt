package team.iwfsg.fsg.domain.order.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class OrderRepositoryTest : BehaviorSpec({
    Given("orderRepository") {
        val orderRepository = mockk<OrderRepository>() {
           When("Create OrderRepository") {
               Then("OrderRepository is not null") {
                   orderRepository shouldNotBe null
               }
           }
        }
    }
})