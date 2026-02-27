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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.reringuy.pinterwork.component.EmailTextField
import com.reringuy.pinterwork.component.GoogleButton
import org.jetbrains.compose.resources.painterResource
import pinterwork.composeapp.generated.resources.Res
import pinterwork.composeapp.generated.resources.icons8_pinterest_logo_48
import pinterwork.composeapp.generated.resources.image1
import pinterwork.composeapp.generated.resources.image2
import pinterwork.composeapp.generated.resources.image3
import pinterwork.composeapp.generated.resources.image4
import pinterwork.composeapp.generated.resources.image6
import pinterwork.composeapp.generated.resources.image7

@Composable
fun LoginScreenWrapper(onNavigatToCredentials: (String) -> Unit) {
    LoginScreen(onNavigatToCredentials)
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginScreen(onNavigatToCredentials: (String) -> Unit) {
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
            EmailTextField(value = email, onDone = {}) { email = it }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigatToCredentials(email.trim()) },
                enabled = email.isNotEmpty(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Continuar", style = MaterialTheme.typography.titleMedium)
            }

            GoogleButton {  }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )

            if (email.isNotEmpty())
                EmailCarrousel { email += it }
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
            painter = painterResource(resource = Res.drawable.image2),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(128.dp).align(Alignment.Center).graphicsLayer {
                scaleX = imageOneScale.value
                scaleY = imageOneScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.image3),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(64.dp)
                .zIndex(-1f)
                .align { size, size1, _ ->
                    IntOffset(
                        x = size1.width / 2 + size.width / 2,
                        y = size1.height /2 + size.height / 2
                    )
                }.graphicsLayer {
                    scaleX = imageOneScale.value
                    scaleY = imageOneScale.value
                    transformOrigin = TransformOrigin.Center
                }
        )
        Image(
            painter = painterResource(resource = Res.drawable.image4),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(128.dp).align(Alignment.BottomStart).graphicsLayer {
                scaleX = imageTwoScale.value
                scaleY = imageTwoScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.image7),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(64.dp, 128.dp).graphicsLayer {
                scaleX = imageThreeScale.value
                scaleY = imageThreeScale.value
                transformOrigin = TransformOrigin.Center
            }
        )
        Image(
            painter = painterResource(resource = Res.drawable.image1),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(64.dp, 128.dp).align(Alignment.BottomEnd).padding(0.dp, 16.dp)
                .graphicsLayer {
                    scaleX = imageThreeScale.value
                    scaleY = imageThreeScale.value
                    transformOrigin = TransformOrigin.Center
                }
        )
        Image(
            painter = painterResource(resource = Res.drawable.image6),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Fit,
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
