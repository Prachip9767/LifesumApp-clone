package com.example.lifesum.LocalDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.lifesum.models.DailyMealData
import com.example.lifesum.models.DashboardEntity
import com.example.lifesum.models.UserEntity

@Dao
interface DAO {

    //user
    @Insert(onConflict = REPLACE)
    fun insertUserDetails(user: UserEntity)

    @Query("Select * from User")
    fun getUserFromDB(): LiveData<UserEntity>

    //insert
    @Insert(onConflict = REPLACE)
    fun insertToDashBoard(dsb: DashboardEntity)

    @Insert(onConflict = REPLACE)
    fun insertToMealData(mealData: DailyMealData)

    //fetch
    @Query("Select * from DashBoardTable where date like :date")
    fun getDashboardDataFromDb(date:String): LiveData<DashboardEntity>

    @Query("Select * from DailyMealDataTable")
    fun getMealData(): LiveData<DailyMealData>

    //delete
    @Delete
    fun deleteMeal(mealObj: DailyMealData)
}