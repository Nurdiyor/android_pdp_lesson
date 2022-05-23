package uz.micro.star.lesson_34.retrofit.models.response


data class TrainerResponse(
    var id: Int,
    var trainerName: String,
    var trainerSalary: Double,
    var trainerSurname: String
)