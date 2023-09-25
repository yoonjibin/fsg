package team.iwfsg.fsg.domain.user.domain


data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val money: Long
)
