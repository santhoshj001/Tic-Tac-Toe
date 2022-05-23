package com.teamb.tictactoe.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.teamb.tictactoe.ClickAction
import com.teamb.tictactoe.TicTacToeState


@Composable
fun TicTacToe(
    state: TicTacToeState,
    modifier: Modifier,
    onclick: (ClickAction) -> Unit
) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (state.isFinished) {
            Text(
                text = state.finishMessage,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(32.dp),
                color = Color.Yellow
            )
        } else {
            Text(
                text = if (state.isPlayerX) "Player X" else " Player O",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(32.dp)
            )
        }
        Divider()
        Row(
            Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TileButton(symbol = state.values[0], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(0)) })
            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            TileButton(symbol = state.values[1], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(1)) })
            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            TileButton(symbol = state.values[2], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(2)) })
        }
        Divider()
        Row(
            Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TileButton(symbol = state.values[3], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(3)) })
            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            TileButton(symbol = state.values[4], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(4)) })
            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            TileButton(symbol = state.values[5], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(5)) })

        }
        Divider()
        Row(
            Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TileButton(symbol = state.values[6], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(6)) })

            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            TileButton(symbol = state.values[7], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(7)) })
            Divider(
                Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            TileButton(symbol = state.values[8], modifier = Modifier
                .weight(1f)
                .aspectRatio(1f), onClick = { onclick(ClickAction.TileClick(8)) })

        }
        Divider()

        Button(onClick = { onclick(ClickAction.GameReset) }, modifier = Modifier.padding(32.dp)) {
            Text(text = "Reset Game")
        }
    }


}