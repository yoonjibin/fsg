package team.iwfsg.fsg.domain.post.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.post.persistence.entity.PostViewCountEntity

interface PostViewCountRepository : CrudRepository<PostViewCountEntity, Long> {
}