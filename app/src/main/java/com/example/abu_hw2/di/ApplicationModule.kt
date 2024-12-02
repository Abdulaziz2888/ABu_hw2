package com.example.abu_hw2.di

import android.content.Context
import android.content.SharedPreferences
import com.example.abu_hw2.SharedPreferencesHelper
import com.example.abu_hw2.data.LoveApiService
import com.example.abu_hw2.mvvm.repository.LoveRepository
import com.example.abu_hw2.mvvm.viewmodel.LoveViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    @Singleton
    fun provideLoveApiService(): LoveApiService {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoveApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): SharedPreferencesHelper {
        return SharedPreferencesHelper(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideLoveRepository(api: LoveApiService): LoveRepository {
        return LoveRepository(api)
    }

    @Provides
    @Singleton
    fun provideLoveViewModel(repository: LoveRepository): LoveViewModel {
        return LoveViewModel(repository)

    }
}