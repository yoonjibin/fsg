package team.iwfsg.fsg.domain.post.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.post.persistence.entity.PostJpaEntity

interface PostRepository : CrudRepository<PostJpaEntity, Long> {

}