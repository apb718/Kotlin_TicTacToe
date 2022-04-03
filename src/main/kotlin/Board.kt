import kotlin.math.pow

class Board(private val n: Int) {

    private val empty = "___"
    private var moveCount = 0
    var isGameOver = false



    var board = Array(n) {  Array(n) { empty } }

    fun resetBoard() {
        board = Array(n) {  Array(n) { empty } }
    }

    fun printBoard() {
        board.forEach { row ->
            row.forEach { element ->
                print("|$element|")

            }
            println()
        }
        println()
    }

    fun placePiece(x: Int, y: Int, move: String) {
        if (!isGameOver && isPositionValid(x,y) == true && board[x][y] == empty ){
            moveCount++
            board[x][y] = "_" + move + "_"
            printBoard()
            isGameOver = isWinningMove(x,y,move) || isDraw()
            if(isGameOver && !isDraw()){
                println("Winner winner chicken dinner")
            }
            else if(isDraw()){
                println("Draw")
            }
        }
    }

    fun isPositionValid(x: Int, y: Int): Boolean {
        return ((x in 0 until n) && (y in 0 until n))
    }

    fun resetGame() {
        resetBoard()
        moveCount = 0
        isGameOver = false
    }

    fun isDraw(): Boolean {
        return (moveCount == n.toDouble().pow(2).toInt())
    }

    private fun isWinningMove(x: Int, y: Int, move: String): Boolean {
        //check the row
        for(i in 0 until n) {
//            println(i);
            if (board[x][i] != "_" + move + "_"){
                break
            }
            if (i == n-1) {
//                println("Winning By Horizontal")
                return true
            }
        }
        // check col
        for(i in 0 until n) {
            if (board[i][y] != "_" + move + "_"){
                break
            }
            if(i ==n-1) {
//                println("Winning By Vert")
                return true
            }
        }

        //check diagonal
        if(x == y) {
            for (i in 0 until n) {
                if (board[i][i] != "_" + move + "_") {
                    break
                }
                if(i == n-1){
//                    println("Winning By Diag1")
                    return true
                }
            }
        }
        //check other diagonal
        if( x + y == n - 1){
            for(i in 0 until n ) {
                if(board[i][(n-1)-i] != "_" + move + "_"){
                    break
                }
                if( i == n-1){
//                    println("Winning By Diag2")
                    return true
                }
            }
        }
//        println("Returning False")
        return false
    }
}