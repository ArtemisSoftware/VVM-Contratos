package com.artemissoftware.vvmcontratos.di

import android.app.Application
import com.artemissoftware.vvmcontratos.api.ContratosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RedeModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(application: Application?): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        //--val webServiceInterceptor = WebServiceInterceptor()

        //--val ligacaoInternetInterceptor = LigacaoInternetInterceptor(application)

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
//            .addInterceptor(ligacaoInternetInterceptor)
//            .addInterceptor(webServiceInterceptor) //establish connection to server
//            .connectTimeout(ApiConstantes.CONNECTION_TIMEOUT, TimeUnit.SECONDS) //time between each byte read from the server
//            .readTimeout(ApiConstantes.READ_TIMEOUT, TimeUnit.SECONDS) //time between each byte sent to server
//            .writeTimeout(ApiConstantes.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
    }



    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ContratosApi.URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }





    @Provides
    @Singleton
    fun provideContratosApi(retrofit: Retrofit): ContratosApi {
        return retrofit.create(ContratosApi::class.java)
    }


//    @Provides
//    @Singleton
//    fun provideRedeRepositorio(
//        segurancaAlimentarApi: SegurancaAlimentarApi?, segurancaTrabalhoApi: SegurancaTrabalhoApi?,
//        transferenciasDao: TransferenciasDao_v2?
//    ): RedeRepositorio? {
//        return RedeRepositorio(segurancaAlimentarApi, segurancaTrabalhoApi, transferenciasDao)
//    }

}