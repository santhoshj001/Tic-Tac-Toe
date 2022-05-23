package com.teamb.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {

    var state by mutableStateOf(TicTacToeState())
        private set

    fun onAction(action: ClickAction) {
        when (action) {
            ClickAction.GameReset -> resetGame()
            is ClickAction.TileClick -> handleTileClick(action.position)
        }
    }

    private fun handleTileClick(position: Int) {
        if (state.values[position].isNotBlank())
            return

        val coin = if (state.isPlayerX) "X" else "O"
        state.values[position] = coin

        if (checkForVictory(coin)) {
            state = state.copy(isFinished = true, finishMessage = "Player $coin Wins")
            return
        }
        if (state.values.none { it.isBlank() }) {
            state = state.copy(isFinished = true, finishMessage = "Draw")
            return
        }
        state = state.copy(isPlayerX = !state.isPlayerX)
    }

    private fun checkForVictory(coin: String): Boolean {

        with(state.values) {
            // horizontal lines
            if (this[0] == coin && this[1] == coin && this[2] == coin)
                return true

            if (this[3] == coin && this[4] == coin && this[5] == coin)
                return true

            if (this[6] == coin && this[7] == coin && this[8] == coin)
                return true

            // vertical lines
            if (this[0] == coin && this[3] == coin && this[6] == coin)
                return true

            if (this[1] == coin && this[4] == coin && this[7] == coin)
                return true

            if (this[2] == coin && this[5] == coin && this[8] == coin)
                return true

            //diagonals
            if (this[0] == coin && this[4] == coin && this[8] == coin)
                return true

            if (this[2] == coin && this[4] == coin && this[6] == coin)
                return true

        }

        return false
    }

    private fun resetGame() {
        state = TicTacToeState()
    }
}