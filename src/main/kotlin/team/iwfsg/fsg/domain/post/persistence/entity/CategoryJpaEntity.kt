package team.iwfsg.fsg.domain.post.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class CategoryJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "post_id")
    val postId: PostJpaEntity
)
