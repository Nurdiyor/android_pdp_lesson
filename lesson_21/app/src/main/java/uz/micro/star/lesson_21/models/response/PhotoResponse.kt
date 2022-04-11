package uz.micro.star.lesson_21.models.response

data class PhotoResponse(
    var albumId: Int,
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String,
)