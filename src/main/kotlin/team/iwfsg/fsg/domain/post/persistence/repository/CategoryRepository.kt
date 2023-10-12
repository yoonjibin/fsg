package team.iwfsg.fsg.domain.post.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.post.persistence.entity.CategoryJpaEntity

interface CategoryRepository : CrudRepository<CategoryJpaEntity, Long> {
}