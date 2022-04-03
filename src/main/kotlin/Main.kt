import java.util.*

private var board = Board(0)
private val player1 ="X"
private val player2 = "O"
private var currentPlayer = ""
private var answer = ""

fun main() {
    val input = Scanner(System.`in`)

    println("Please enter the size of your board")
    val size = Integer.parseInt(input.nextLine())
    board = Board(size)
    board.printBoard()

    while(!board.isGameOver){
        takeTurns()
        println("$currentPlayer's turn")
        var validRow = false
        var validCol = false
        while(!validRow || !validCol){
            println("Enter Row Number:")
            val row = Integer.parseInt(input.nextLine()) - 1
            if(row == 0 || row == 1 || row == 2){
                validRow = true
            }
            else {
                println("Invalid Row")
            }
            if(validRow==true) {
                println("Enter Column Number:")
                val col = Integer.parseInt(input.nextLine()) - 1
                if (col == 0 || col == 1 || col == 2) {
                    validCol = true
                    board.placePiece(row, col, currentPlayer)
                } else {
                    println("Invalid Column")
                }

            }
        }


        if(board.isGameOver) {
            println("Do you want to play again? Type y or yes")
            answer = input.nextLine()
            if(isPlayingAgain(answer)){
                board.resetGame()
                for(i in 0 until 100){
                    println()
                }
                board.printBoard()
            }
            else {
                println("Thank you for playing Tic Tac Toe!")
            }
        }

    }


}

fun takeTurns() {
    currentPlayer = if(player1 == currentPlayer){
        player2
    }
    else {
        player1
    }
}

fun isPlayingAgain(answer: String): Boolean {
    return (answer.equals("y", ignoreCase = true)
            || answer.equals("yes", ignoreCase = true))
}