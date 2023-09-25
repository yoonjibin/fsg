package team.iwfsg.fsg.domain.order.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.order.persistence.entity.OrdersJpaEntity

interface OrderRepository : CrudRepository<OrdersJpaEntity, Long> {
}