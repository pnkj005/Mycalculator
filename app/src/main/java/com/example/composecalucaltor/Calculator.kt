package com.example.composecalucaltor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            // First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    color = Color.LightGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorActions.Clear) }
                )
                CalculatorButton(
                    symbol = "DEL",
                    color = Color.LightGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Delete) }
                )
                CalculatorButton(
                    symbol = "/",
                    //color = Color.Yellow,
                    modifier = Modifier.background(Color(0xFFFFA500))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Divide)) }
                )
            }

            // Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton("7", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(7)) }
                CalculatorButton("8", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(8)) }
                CalculatorButton("9", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(9)) }
                CalculatorButton("x", Modifier.background(Color(0xFFFFA500)).aspectRatio(1f).weight(1f), Color.Yellow) { onAction(CalculatorActions.Operation(CalculatorOperation.Multiply)) }
            }

            // Third Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton("4", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(4)) }
                CalculatorButton("5", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(5)) }
                CalculatorButton("6", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(6)) }
                CalculatorButton("-", Modifier.background(Color(0xFFFFA500)).aspectRatio(1f).weight(1f), Color.Yellow) { onAction(CalculatorActions.Operation(CalculatorOperation.Subtract)) }
            }

            // Fourth Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton("1", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(1)) }
                CalculatorButton("2", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(2)) }
                CalculatorButton("3", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Number(3)) }
                CalculatorButton("+", Modifier.background(Color(0xFFFFA500)).aspectRatio(1f).weight(1f), Color.Yellow) { onAction(CalculatorActions.Operation(CalculatorOperation.Add)) }
            }

            // Fifth Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton("0", Modifier.aspectRatio(2f).weight(2f), Color.DarkGray) { onAction(CalculatorActions.Number(0)) }
                CalculatorButton(".", Modifier.aspectRatio(1f).weight(1f), Color.DarkGray) { onAction(CalculatorActions.Decimal) }
                CalculatorButton("=", Modifier.background(Color(0xFFFFA500)).aspectRatio(1f).weight(1f)) { onAction(CalculatorActions.Calculator) }
            }
        }
    }
}


