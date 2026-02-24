package com.reringuy.pinterwork.screen

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.jetbrains.compose.resources.painterResource
import pinterwork.composeapp.generated.resources.Res
import pinterwork.composeapp.generated.resources.compose_multiplatform
import pinterwork.composeapp.generated.resources.icons8_google_48
import pinterwork.composeapp.generated.resources.icons8_pinterest_logo_48

@Composable
fun LoginScreenWrapper() {
}

@Composable
fun LoginScreen() {
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        LoginHeader(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth().padding(24.dp, 12.dp),
            text = "Crie uma vida\ncom o que você ama",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp, 12.dp).imePadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = { },
                shape = MaterialTheme.shapes.medium,
                label = {
                    Text(
                        text = "Endereço de email",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Continuar", style = MaterialTheme.typography.titleMedium)
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(resource = Res.drawable.icons8_google_48),
                        contentDescription = "Google"
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Continuar com o Google",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun LoginHeader(modifier: Modifier) {
    val imageOneTransition = rememberInfiniteTransition("image_one_transition")
    val imageTwoTransition = rememberInfiniteTransition("image_two_transition")
    val imageThreeTransition = rememberInfiniteTransition("image_three_transition")

    val imageOneScale = imageOneTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scaleOne"
    )
    val imageTwoScale = imageTwoTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(tween(800), RepeatMode.Reverse),
        label = "scaleTwo"
    )
    val imageThreeScale = imageThreeTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Reverse),
        label = "scaleThree"
    )


    Box(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.align(Alignment.BottomCenter).size(48.dp),
            painter = painterResource(resource = Res.drawable.icons8_pinterest_logo_48),
            contentDescription = "Pinterest"
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp, 128.dp).align(Alignment.Center).graphicsLayer {
                scaleX = imageOneScale.value
                scaleY = imageOneScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(48.dp, 64.dp)
                .zIndex(-1f)
                .align { size, size1, _ ->
                    IntOffset(
                        x = size1.width / 2 + size.width / 2,
                        y = size1.height / 2 - (size.height / 1.2).toInt()
                    )
                }.graphicsLayer {
                    scaleX = imageOneScale.value
                    scaleY = imageOneScale.value
                    transformOrigin = TransformOrigin.Center
                }
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp, 128.dp).align(Alignment.BottomStart).graphicsLayer {
                scaleX = imageTwoScale.value
                scaleY = imageTwoScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp, 128.dp).graphicsLayer {
                scaleX = imageThreeScale.value
                scaleY = imageThreeScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp, 128.dp).align(Alignment.BottomEnd).padding(0.dp, 16.dp)
                .graphicsLayer {
                    scaleX = imageThreeScale.value
                    scaleY = imageThreeScale.value
                    transformOrigin = TransformOrigin.Center
                }
        )
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp, 128.dp).align { size, size1, _ ->
                IntOffset(
                    x = size1.width / 2 + (size.width * 2.2).toInt(),
                    y = size1.height / 8 - size.height
                )
            }
                .graphicsLayer {
                    scaleX = imageThreeScale.value
                    scaleY = imageThreeScale.value
                    transformOrigin = TransformOrigin.Center
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen()
    }
}