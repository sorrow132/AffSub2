package yuresko.affsub2.repository

import io.reactivex.Single
import yuresko.affsub2.network.ApiService
import yuresko.affsub2.network.model.User

interface IRepository {

    fun getRandomUser(): Single<User>

}

class RepositoryImpl(private val network: ApiService) : IRepository {

    override fun getRandomUser(): Single<User> {
        return network.getUser()
    }


}