package app.training.android.di

import app.training.android.api.FakeStoreApi
import app.training.android.api.ProductRepository
import app.training.android.api.RetrofitService
import app.training.android.api.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TrainingModule {

    @Provides
    @Singleton
    fun provideApiService(): FakeStoreApi{
        return RetrofitService.getApiService()
    }

    @Provides
    @Singleton
    fun provideProductRepository(apiService: FakeStoreApi): ProductRepository{
        return ProductRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: FakeStoreApi): UserRepository{
        return UserRepository()
    }
}