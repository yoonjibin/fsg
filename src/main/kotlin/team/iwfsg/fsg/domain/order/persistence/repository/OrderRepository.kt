package team.iwfsg.fsg.domain.order.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.order.persistence.entity.OrderJpaEntity

interface OrderRepository : CrudRepository<OrderJpaEntity, Long> {
}