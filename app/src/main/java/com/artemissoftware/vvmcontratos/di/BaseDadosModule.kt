package com.artemissoftware.vvmcontratos.di

import android.app.Application
import androidx.room.Room
import com.artemissoftware.vvmcontratos.baseDados.BaseDados
import com.artemissoftware.vvmcontratos.utils.constantes.NOME_BASE_DADOS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object BaseDadosModule {

    @Provides
    @Singleton
    fun provideBaseDados(app: Application/*, callback: BaseDados.Callback*/): BaseDados {
        return Room.databaseBuilder(app, BaseDados::class.java, NOME_BASE_DADOS)
            .fallbackToDestructiveMigration()
            //.addCallback(callback)
            .build()
    }


    @Provides
    fun provideTipoDao(db: BaseDados) = db.tipoDao()

}