package team.iwfsg.fsg.domain.order.persistence.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import team.iwfsg.fsg.domain.product.persistence.entity.Product
import team.iwfsg.fsg.domain.user.persistence.entity.User
import java.time.LocalDateTime

@Entity
@Table(name = "order")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product", nullable = false)
    val product: Product,

    @Column(name = "created_at")
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime
) {
}