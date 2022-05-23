package com.teamb.tictactoe

sealed class ClickAction {
    object GameReset : ClickAction()
    data class TileClick(val position: Int) : ClickAction()
}
