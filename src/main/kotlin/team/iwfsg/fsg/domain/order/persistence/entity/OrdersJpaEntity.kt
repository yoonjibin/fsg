package team.iwfsg.fsg.domain.order.persistence.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.iwfsg.fsg.domain.product.persistence.entity.ProductJpaEntity
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class OrdersJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    val userId: UserJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    val productId: ProductJpaEntity,

    @Column(name = "created_at")
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime
)