package com.artemissoftware.vvmcontratos.di

import android.app.Application
import androidx.room.Room
import com.artemissoftware.vvmcontratos.api.ContratosApi
import com.artemissoftware.vvmcontratos.baseDados.BaseDados
import com.artemissoftware.vvmcontratos.baseDados.dao.AtualizacaoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.TipoDao
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorioImpl
import com.artemissoftware.vvmcontratos.repositorios.TipoRepositorio
import com.artemissoftware.vvmcontratos.repositorios.TipoRepositorioImpl
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

    @Provides
    fun provideAtualizacaoDao(db: BaseDados) = db.atualizacaoDao()


    @Provides
    @Singleton
    fun provideTipoRepositorio(atualizacaoDao: AtualizacaoDao, tipoDao: TipoDao): TipoRepositorio {
        return TipoRepositorioImpl(atualizacaoDao, tipoDao)
    }
}