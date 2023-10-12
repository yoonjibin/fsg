package team.iwfsg.fsg.domain.post.persistence.entity

import jakarta.persistence.*
import team.iwfsg.fsg.domain.post.domain.enums.PostType

@Entity
@Table(name = "post")
class PostJpaEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   val id: Long,

   @Column(nullable = false)
   val title: String,

   @Column(nullable = false)
   val content: String,

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   val boardType: PostType,

   @Column(nullable = false)
   val writerId: Long
)