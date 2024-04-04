package app.lhmako.ui.guideline.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.lhmako.ui.guideline.theme.Brown
import app.lhmako.ui.guideline.theme.Yellow

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonColors(Yellow, Brown, Color.Gray, Color.DarkGray),
        onClick = onClick
    ) {
        Text(text = text)
    }
}