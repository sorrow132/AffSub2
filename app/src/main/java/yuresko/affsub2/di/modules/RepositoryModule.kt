package yuresko.affsub2.di.modules

import dagger.Module
import dagger.Provides
import yuresko.affsub2.network.ApiService
import yuresko.affsub2.repository.IRepository
import yuresko.affsub2.repository.RepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(network: ApiService): IRepository {
        return RepositoryImpl(network)
    }

}