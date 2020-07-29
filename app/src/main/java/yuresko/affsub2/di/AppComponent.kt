package yuresko.affsub2.di

import dagger.Component
import yuresko.affsub2.InfoActivity
import yuresko.affsub2.mainview.MainActivity
import yuresko.affsub2.di.modules.NetworkModule
import yuresko.affsub2.di.modules.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(provider: MainActivity)
    fun inject(provider: InfoActivity)
}