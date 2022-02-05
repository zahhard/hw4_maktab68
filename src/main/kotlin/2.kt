class Permutation(var str: String, var ans: String, var next: String) {
    var list = ArrayList<String>()
    fun printPermutn(str: String, ans: String) {
        if (str.isEmpty() && !list.contains(ans)) {
            list.add(ans)
            return
        }
        for (i in str.indices) {
            val ch = str[i]
            val ros = str.substring(0, i) + str.substring(i + 1)
            printPermutn(ros, ans + ch);
        }
    }

    fun isPass(next: String) {
        println()
        println(list)
        if (list.contains(next))
            println("pass")
        else
            println("fail")
    }
}

fun main() {
    val s = readLine()
    val next = readLine()
    if (s != null && next != null) {
        val permutation = Permutation(s, "", next)
        permutation.printPermutn(s, "")
        permutation.isPass(next)
    }

}
