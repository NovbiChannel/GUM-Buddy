package com.example.gumbuddy.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.gumbuddy.db.TrainingDatabase
import com.example.gumbuddy.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.gumbuddy.other.Constants.KEY_NAME
import com.example.gumbuddy.other.Constants.SHARED_PREFERENCES_NAME
import com.example.gumbuddy.other.Constants.TRAINING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTrainingDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        TrainingDatabase::class.java,
        TRAINING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideTrainingDao(db: TrainingDatabase) = db.getTrainingDao()

    @Singleton
    @Provides
    fun provideLinearDao(db: TrainingDatabase) = db.getLinearDao()

    @Singleton
    @Provides
    fun providePyramidDao(db: TrainingDatabase) = db.getPyramidDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) =
        sharedPref.getBoolean(
            KEY_FIRST_TIME_TOGGLE, true)
}