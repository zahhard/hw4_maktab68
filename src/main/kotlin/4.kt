import java.util.*

fun main() {
    val restaurant = Restaurant()
    restaurant.main1()
}

open class Food(var calories: Long) : Comparable<Food> {
    override fun compareTo(other: Food): Int {
        if (calories > other.calories) return 0
        else if (calories == other.calories)  return 1
        else return -1
    }
}

class Restaurant {
    fun main1() {
        val foodList = Array<Food?>(10) { null }
        foodList[0] = Hamburger(155)
        foodList[1] = Falafel(1)
        foodList[2] = Hamburger(55)
        foodList[3] = Pizza(651)
        foodList[4] = Falafel(159)
        foodList[5] = Hamburger(123)
        foodList[6] = Pizza(1222)
        foodList[7] = Falafel(14520)
        foodList[8] = Hamburger(11)
        foodList[9] =Pizza(9589)

        Arrays.sort(foodList)
        for (food in foodList){
            println(food)
        }
    }
}

class Falafel(calories: Long) : Food(calories) {
    override fun toString(): String{
        return ("name: Falafel   * calori: ${this.calories}")
    }
}

class Pizza(calories: Long) : Food(calories) {
    override fun toString(): String{
        return ("name: Pizza     * calori: ${this.calories}")
    }
}

class Hamburger(calories: Long) : Food(calories) {
    override fun toString(): String{
        return ("name: Hamburger * calori: ${this.calories}")
    }
}


