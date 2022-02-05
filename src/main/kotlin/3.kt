abstract class DiscountStrategy{
    abstract fun priceByDiscount(clothing: Clothing): Long
}
open class SummerDiscountStrategy(): DiscountStrategy() {
    override fun priceByDiscount(clothing: Clothing): Long {
        if (clothing.season == Season.SPRING) {
            clothing.price = ((clothing.price * 0.6).toLong())
        }
        if (clothing.season == Season.SUMMER) {
            clothing.price = ((clothing.price * 0.5).toLong())
        }
        if (clothing.season == Season.WINTER) {
            clothing.price = ((clothing.price * 0.7).toLong())
        }
        return (clothing.price).toLong()
    }
}
open class WinterDiscountStrategy(): DiscountStrategy(){
    override fun priceByDiscount(clothing: Clothing): Long {

        if (clothing.season == Season.FALL) {
            clothing.price = ((clothing.price * 0.6).toLong())
            return clothing.price
        }
        if (clothing.season == Season.WINTER) {
            clothing.price = ((clothing.getPrice() * 0.5).toLong())
            return clothing.price
        }
        if (clothing.season == Season.SUMMER) {
            clothing.price = ((clothing.price * 0.75).toLong())
            return clothing.price
        }
        if (clothing is Jacket) {
            clothing.price = ((clothing.price * 0.9).toLong())
            return clothing.price
        }
        return (clothing.price).toLong()
    }
}
open class YaldaDiscountStrategy(): DiscountStrategy(){
    override fun priceByDiscount(clothing: Clothing): Long {
        if (clothing is Jacket) {
            clothing.price = ((clothing.price * 0.9).toLong())
            return (clothing.price).toLong()
        }
        else if (clothing is Socks) {
            clothing.price = ((clothing.price * 0.8).toLong())
            return (clothing.price).toLong()
        }
        else{
            clothing.price = ((clothing.price * 0.75).toLong())
            return (clothing.price).toLong()
        }
    }
}
abstract class Clothing(var name: String, var season: Season, var price: Long) {

    fun setDiscountStrategy(discountStrategy: DiscountStrategy){
        if (discountStrategy is YaldaDiscountStrategy){
            (discountStrategy).priceByDiscount(this)
        }
        else if (discountStrategy is WinterDiscountStrategy){
            (discountStrategy).priceByDiscount(this)
        }
        else if (discountStrategy is SummerDiscountStrategy){
            (discountStrategy).priceByDiscount(this)
        }
    }
    @JvmName("getPrice1")
    fun getPrice(): Long{
        return this.price
    }
}
class Jacket(name: String, season: Season, price: Long) : Clothing(name, season, price){
}
class Socks(name: String, season: Season, price: Long) : Clothing(name, season, price) {
}
class Shirt(name: String, season: Season, price: Long) : Clothing(name, season, price) {
}
class Pants(name: String, season: Season, price: Long) : Clothing(name, season, price) {
}
enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

fun main() {
    val leninCoat = Jacket("Lenin Coat", Season.FALL, 100000)
    println("Lenin Coat : " + leninCoat.price)

    leninCoat.setDiscountStrategy(YaldaDiscountStrategy())
    println("Lenin Coat with Yalda discount: " + leninCoat.price)

    leninCoat.setDiscountStrategy(WinterDiscountStrategy())
    println("Lenin Coat with Winter discount: " + leninCoat.price)

    var woolenSocks: Clothing = Pants("Woolen Socks", Season.WINTER, 10000)
    println("Woolen Socks: " + woolenSocks.price)

    woolenSocks.setDiscountStrategy(SummerDiscountStrategy())
    println("Woolen Socks with Summer discount: " + woolenSocks.price)

    woolenSocks= Pants("Woolen Socks", Season.WINTER, 10000)
    woolenSocks.setDiscountStrategy(WinterDiscountStrategy())
    println("Woolen Socks with Winter discount: " + woolenSocks.price)
}
