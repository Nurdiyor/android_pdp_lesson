package uz.micro.star.lesson_22.models.response


data class TrainerResponse(
    var id: Int,
    var trainerName: String,
    var trainerSalary: Double,
    var trainerSurname: String
)