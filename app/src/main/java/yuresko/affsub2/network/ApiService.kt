package yuresko.affsub2.network

import io.reactivex.Single
import retrofit2.http.GET
import yuresko.affsub2.network.model.User

interface ApiService {

    @GET("/api/")
    fun getUser(): Single<User>

}