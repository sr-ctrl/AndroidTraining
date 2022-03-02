package com.example.androidtraining

import androidx.multidex.MultiDexApplication
import com.example.androidtraining.di.repositoryModule
import com.example.androidtraining.di.retrofitModule
import com.example.androidtraining.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppApplication : MultiDexApplication(){
//    val  applicationScope = CoroutineScope(SupervisorJob())
//    val database by lazy { RoomInstance.getDatabase(this,applicationScope) }
//    val repository by lazy { RoomRepository(database.dataDao()) }
    companion object {
        lateinit var instance: AppApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this@AppApplication
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AppApplication)
            modules(listOf(retrofitModule,repositoryModule,viewModelModule))
        }
    }
}