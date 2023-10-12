package team.iwfsg.fsg.domain.post.persistence.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import team.iwfsg.fsg.domain.post.domain.enums.PostType
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity
import java.time.LocalDateTime

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

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
   @Column(nullable = false)
   val createdAt: LocalDateTime,

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(nullable = false, name = "writer_id")
   val writerId: UserJpaEntity
)