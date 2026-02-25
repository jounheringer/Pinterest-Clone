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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().systemBarsPadding().imePadding()
    ) {
        LoginHeader(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth().padding(24.dp, 12.dp),
            text = "Crie uma vida\ncom o que você ama",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp, 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it.trim() },
                shape = MaterialTheme.shapes.medium,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Unspecified,
                    imeAction = ImeAction.Done,
                    platformImeOptions = null,
                    showKeyboardOnFocus = null,
                    hintLocales = null
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                trailingIcon = {
                    if (email.isNotEmpty())
                        IconButton(onClick = { email = "" }) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = "Limpar")
                        }
                },
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

            if (email.isNotEmpty())
                EmailCarrousel {
                    email += it
                }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun EmailCarrousel(onItemClicked: (String) -> Unit) {
    val emailList = listOf("gmail", "hotmail", "outlook", "yahoo", "icloud", "bol", "live")
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        emailList.forEach {
            item {
                TextButton(
                    onClick = { onItemClicked("@$it.com") },
                    shapes = ButtonDefaults.shapes().copy(
                        shape = MaterialTheme.shapes.medium
                    ),
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    Text(text = "@$it.com", style = MaterialTheme.typography.bodyMedium)
                }
            }

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