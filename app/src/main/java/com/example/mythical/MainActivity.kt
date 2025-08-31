package com.example.mythical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mythical.data.Datasource
import com.example.mythical.model.Character
import com.example.mythical.ui.theme.MythicalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MythicalTheme {
                MythicalCharactersApp()
            }
        }
    }
}


@Composable
fun MythicalCharactersApp() {
    val mythicalCharacters = Datasource.getCharactersList()

    Scaffold(
        topBar = { MythicalTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(mythicalCharacters) {
                CharacterCard(
                    character = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MythicalTopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.app_name)) }
    )
}

@Composable
fun CharacterCard(character: Character, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CharacterImage(
                imageId = character.imageId,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small)
            )
            CharacterInfo(
                nameId = character.nameId,
                descriptionId = character.descriptionId,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun CharacterInfo(
    @StringRes nameId: Int,
    @StringRes descriptionId: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(nameId), style = MaterialTheme.typography.titleMedium)
        Text(text = stringResource(descriptionId), style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun CharacterImage(@DrawableRes imageId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MythicalCharacterPreview() {
    MythicalTheme {
        CharacterCard(
            Character(R.string.name1, R.string.description1, R.drawable.myth1)
        )
    }
}

@Preview
@Composable
fun MythicalCharactersAppPreview() {
    MythicalTheme {
        MythicalCharactersApp()
    }
}