package uz.micro.star.lesson_34.utils

import androidx.recyclerview.widget.DiffUtil
import uz.micro.star.lesson_34.dto.TrainerDto


/**
 * Created by Microstar on 13.04.2022.
 */
class TrainerDiffCallback(var oldList: List<TrainerDto>, var newList: List<TrainerDto>) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(p0: Int, p1: Int) = oldList[p0].id == newList[p1].id
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areContentsTheSame(p0: Int, p1: Int) =
        oldList[p0].trainerName == newList[p1].trainerName
                && oldList[p0].trainerSalary == newList[p1].trainerSalary
                && oldList[p0].trainerSurname == newList[p1].trainerSurname
}
