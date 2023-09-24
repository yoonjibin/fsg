package team.iwfsg.fsg.domain.product.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.product.persistence.entity.Product

interface ProductRepository : CrudRepository<Product, Long> {

}