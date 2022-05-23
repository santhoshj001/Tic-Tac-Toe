package com.teamb.tictactoe

import kotlin.random.Random.Default.nextBoolean

data class TicTacToeState(
    val isPlayerX: Boolean = nextBoolean(),
    val values: MutableList<String> = MutableList(9) { "" },
    val isFinished: Boolean = false,
    val finishMessage: String = ""
)
