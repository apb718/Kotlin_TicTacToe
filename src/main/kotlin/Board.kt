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
        if (!isGameOver &&
            board[x][y] == empty
            && isPositionValid(x,y) == true){
            moveCount++
            board[x][y] = "_" + move + "_"
            printBoard()
        }
    }

    fun isPositionValid(x: Int, y: Int): Boolean {
        return ((x in 0 until n) && (y in 0 until n))
    }
}