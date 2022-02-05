fun main() {
    var array = arrayListOf(3, 7,9, 2, 5, 5, 8, 5, 6, 3, 4, 7,3,1)

    if (array.size % 2 != 0) {
        array.removeLast()
    }
    var i = 0
    val willRemove = ArrayList<Int>()
    while (i < array.size) {
        if (array[i] > array[i + 1]) {
            willRemove.add(array[i])
            willRemove.add(array[i+1])
        }
        i += 2
    }
    i = 0
    while (i < array.size){
        var j = 0
        while (j < willRemove.size){
            if (willRemove[j]+willRemove[j+1] == array[i] + array[i+1]){

                array.removeAt(i)
                array.removeAt(i)
                willRemove.removeAt(j)
                willRemove.removeAt(j)
                j -= 2
                j = 0
                break
            }
            j += 2
        }
        i += 1
    }
    println(array)
}