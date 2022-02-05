class Matrix(private var rowCount: Int,
             private var columnCount: Int,
             var matrix: Array<IntArray> = Array(rowCount) { IntArray(columnCount) })
{

    fun getRowCount(): Int{
        return rowCount
    }

    fun getColumnCount(): Int{
        return columnCount
    }

    fun setElements(i: Int, j: Int, item: Int){
        matrix[i-1][j-1] = item
    }

    fun printMatrix(){
        for (i in 0 until rowCount){
            for (j in 0 until columnCount){
                print(matrix[i][j].toString() + " ")
            }
            println()
        }
    }

    fun add(matrix: Matrix):Matrix{
        if (this.rowCount == matrix.getRowCount()) {
            for (i in 0 until rowCount) {
                for (j in 0 until columnCount) {
                    this.matrix[i][j] += matrix.matrix[i][j]
                }
            }
        }
        else
            println("Matrix cannot be added :(")
        return this
    }

}

fun main(){
    var matrix = Matrix(3, 3, arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)))
    matrix.printMatrix()
    println("column number : "+matrix.getColumnCount())
    println("row number : "+matrix.getColumnCount())
    println("-----------------")
    matrix.setElements(2, 2, 11111)
    matrix.printMatrix()
    println("-----------------")
    var matrix2 = Matrix(3, 4, arrayOf(intArrayOf(2, 2, 2), intArrayOf(2, 2, 2), intArrayOf(2, 2, 2)))
    matrix.add(matrix2)
    matrix.printMatrix()
}