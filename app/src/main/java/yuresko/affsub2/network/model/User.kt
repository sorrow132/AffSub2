package yuresko.affsub2.network.model

data class User(
    val results: List<UserInfo>
)

data class UserInfo(
    val gender: String,
    val name: UserName,
    val email: String,
    val login: Login,
    val dob: Dob,
    val phone: String,
    val picture: Picture
)

data class Picture(
    val large: String
)

data class Login(
    val username: String
)

data class Dob(
    val date: String,
    val age: Int
)

data class UserName(
    val title: String,
    val first: String,
    val last: String
)