package com.artemissoftware.vvmcontratos.di

import com.artemissoftware.vvmcontratos.baseDados.BaseDados
import com.artemissoftware.vvmcontratos.baseDados.dao.ClienteDao
import com.artemissoftware.vvmcontratos.baseDados.dao.ContratoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.MoradaDao
import com.artemissoftware.vvmcontratos.repositorios.ContratoRepositorio
import com.artemissoftware.vvmcontratos.repositorios.ContratoRepositorioImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
//@InstallIn(FragmentComponent::class)
object ContratoModule {


    @Provides
    fun provideClienteDao(db: BaseDados) = db.clienteDao()

    @Provides
    //@FragmentScoped
    @Singleton
    fun provideContratoRepositorio(contratoDao: ContratoDao, clienteDao: ClienteDao, moradaDao: MoradaDao): ContratoRepositorio {
        return ContratoRepositorioImpl(contratoDao, clienteDao, moradaDao)
    }
}