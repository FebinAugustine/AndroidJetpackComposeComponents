package com.febin.mycomponents.textFieldComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldComp(
    modifier: Modifier,
) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                var text by rememberSaveable { mutableStateOf("") }

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Label") },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))
// Text field with Placeholder
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier,
                    label = { Text("Label") },
                    singleLine = true,
                    placeholder = { Text("example@gmail.com") }
                )

                Spacer(modifier = Modifier.height(16.dp))
// Text field with Leading and Trailing icons
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier,
                    label = { Text("Label") },
                    singleLine = true,
                    placeholder = { Text("example@gmail.com") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "Localized description"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
// Text field with Prefix or suffix
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier,
                    label = { Text("Label") },
                    singleLine = true,
                    prefix = { Text("www.") },
                    suffix = { Text(".com") },
                    placeholder = { Text("google") },

                    )

                Spacer(modifier = Modifier.height(16.dp))
// Text field To handle the error input state, use isError parameter:
                val errorMessage = "Text input too long"
                var isError by rememberSaveable { mutableStateOf(false) }
                val charLimit = 5

                fun validate(text: String) {
                    isError = text.length > charLimit
                }

                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        text = it
                        validate(text)
                    },
                    singleLine = true,
                    label = { Text(if (isError) "Username*" else "Username") },
                    supportingText = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Limit: ${text.length}/$charLimit",
                            textAlign = TextAlign.End,
                        )
                    },
                    isError = isError,
                    keyboardActions = KeyboardActions { validate(text) },
                    modifier = Modifier.semantics {
                        // Provide localized description of the error
                        if (isError) error(errorMessage)
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
// Text field with Prefix or suffix
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier,
                    label = { Text("Label") },
                    supportingText = {
                        Text("Supporting text that is long and perhaps goes onto another line.")
                    },
                    placeholder = { Text("google") },

                    )
                Spacer(modifier = Modifier.height(16.dp))
// Password Text field
                var password by rememberSaveable { mutableStateOf("") }
                var passwordHidden by rememberSaveable { mutableStateOf(true) }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    label = { Text("Enter password") },
                    visualTransformation =
                    if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            val visibilityIcon =
                                if (passwordHidden) Icons.Filled.Check else Icons.Filled.CheckCircle
                            // Please provide localized description for accessibility services
                            val description = if (passwordHidden) "Show password" else "Hide password"
                            Icon(imageVector = visibilityIcon, contentDescription = description)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
// Hiding a software keyboard on IME action performed:
                val keyboardController = LocalSoftwareKeyboardController.current

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("IME Action") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            // do something here
                        }
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OutlinedTextFieldCompPreview() {
    OutlinedTextFieldComp(
        modifier = Modifier,
    )
}