package team.iwfsg.fsg.domain.product.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class Product(
    val id: Long,
    val name: String,
    val price: Long,
    val description: String
)
