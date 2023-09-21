package team.iwfsg.fsg.domain.order.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.order.persistence.entity.Order

interface OrderRepository : CrudRepository<Order, Long> {
}