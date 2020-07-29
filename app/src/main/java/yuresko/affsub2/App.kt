package yuresko.affsub2

import android.app.Application
import yuresko.affsub2.di.AppComponent
import yuresko.affsub2.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent = DaggerAppComponent
        .builder()
        .build()
}