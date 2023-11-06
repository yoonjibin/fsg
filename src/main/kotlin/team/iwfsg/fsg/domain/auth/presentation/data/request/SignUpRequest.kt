package team.iwfsg.fsg.domain.auth.presentation.data.request

data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String
)
