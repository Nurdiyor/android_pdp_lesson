package uz.micro.star.lesson_34.room

import androidx.room.*
import uz.micro.star.lesson_34.room.entities.TrainerEntity


@Dao
interface InputDao {

    @Query("SELECT * FROM TrainerEntity")
    fun getAllTrainers(): List<TrainerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTrainer(user: TrainerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTrainers(users: List<TrainerEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: TrainerEntity)

    @Delete
    fun deleteUser(user: TrainerEntity)

    @Query("DELETE FROM TrainerEntity")
    fun deleteAll()

/////////////////////////////////////////////////////
}