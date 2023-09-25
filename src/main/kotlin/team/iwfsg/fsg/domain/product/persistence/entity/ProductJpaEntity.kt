package team.iwfsg.fsg.domain.product.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
class ProductJpaEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   val id: Long,

   @Column(nullable = false)
   val name: String,

   @Column(nullable = false)
   val price: Long,

   @Column(nullable = false)
   val description: String
)