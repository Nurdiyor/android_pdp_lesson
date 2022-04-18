package uz.micro.star.lesson_22.models

class TrainerDbModel {
    var trainerId: Int = 0
    var changeType: Int
    var id: Int
    var trainerName: String
    var trainerSurname: String
    var trainerSalary: Double

    constructor(
        trainerId: Int,
        changeType: Int,
        id: Int,
        trainerName: String,
        trainerSurname: String,
        trainerSalary: Double
    ) {
        this.trainerId = trainerId
        this.changeType = changeType
        this.id = id
        this.trainerName = trainerName
        this.trainerSurname = trainerSurname
        this.trainerSalary = trainerSalary
    }

    constructor(
        changeType: Int,
        id: Int,
        trainerName: String,
        trainerSurname: String,
        trainerSalary: Double
    ) {
        this.changeType = changeType
        this.id = id
        this.trainerName = trainerName
        this.trainerSurname = trainerSurname
        this.trainerSalary = trainerSalary
    }

}