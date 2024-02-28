package com.example.mysamplecodes.ui.SampleScreens

import android.view.KeyEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.ui.theme.MySampleCodesTheme
import com.example.mysamplecodes.ui.theme.White_Alpha00
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.White_Alpha50
import com.example.mysamplecodes.ui.theme.disabledColor
import com.example.mysamplecodes.ui.theme.enabledColor
import com.example.mysamplecodes.ui.theme.verticalGradient

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SampleForm(){
    var firstName by remember { mutableStateOf( TextFieldValue(""))}
    var lastName by remember { mutableStateOf( TextFieldValue(""))}
    val countryCode = "+91 "
    var mobileNumber by remember { mutableStateOf( TextFieldValue(""))}
    var emailId by remember { mutableStateOf( TextFieldValue(""))}
    var isEnabled by remember { mutableStateOf( false)}

//    val firstNameFocusRequester = remember { FocusRequester() }
//    val lastNameFocusRequester = remember { FocusRequester() }
//    val mobileFocusRequester = remember { FocusRequester() }
//    val emailFocusRequester = remember { FocusRequester() }
//    val submitButtonFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Box(
//        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = verticalGradient
            )
    ){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {

            item{
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Registration Form",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = White_Alpha100,
                    )
                    Divider(
                        thickness = 1.dp,
                        color = White_Alpha100,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                    )
                    Text(
                        text = "Fill out the form carefully for registration",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = White_Alpha100,
                    )
                }
            }

            item {
                CustomOutlinedTextField(
                    text = firstName,
                    placeHolder = "First Name",
                    label = "First Name",
                    keyboardType = KeyboardType.Text,
//                    focusRequester = firstNameFocusRequester,
                    onValueChange = {
                        firstName = it
                    },
                    onDone = {
                        isEnabled = firstName.text.isNotBlank() && lastName.text.isNotBlank() && mobileNumber.text.isNotBlank() && emailId.text.isNotBlank()
                        focusManager.moveFocus(FocusDirection.Down)
//                        lastNameFocusRequester.requestFocus()
                    },
                    onNext = { println("CKR: clicked Next") },
                    onPrevious = { println("CKR: clicked Previous") }
                )
            }

            item {
                CustomOutlinedTextField(
                    text = lastName,
                    placeHolder = "Last Name",
                    label = "Last Name",
                    keyboardType = KeyboardType.Text,
//                    focusRequester = lastNameFocusRequester,
                    onValueChange = {
                        lastName = it
                    },
                    onDone = {
                        isEnabled = firstName.text.isNotBlank() && lastName.text.isNotBlank() && mobileNumber.text.isNotBlank() && emailId.text.isNotBlank()
                        focusManager.moveFocus(FocusDirection.Down)
//                        mobileFocusRequester.requestFocus()
                    },
                    onNext = { println("CKR: clicked Next") },
                    onPrevious = { println("CKR: clicked Previous") }
                )
            }

            item {
                CustomOutlinedTextField(
                    text = mobileNumber,
                    placeHolder = "Mobile Number",
                    label = "Mobile Number",
                    leadingText = countryCode,
                    keyboardType = KeyboardType.Phone,
//                    focusRequester = mobileFocusRequester,
                    onValueChange = {
                        mobileNumber = it
                    },
                    onDone = {
                        isEnabled = firstName.text.isNotBlank() && lastName.text.isNotBlank() && mobileNumber.text.isNotBlank() && emailId.text.isNotBlank()
                        focusManager.moveFocus(FocusDirection.Down)
//                        emailFocusRequester.requestFocus()
                    },
                    onNext = { println("CKR: clicked Next") },
                    onPrevious = { println("CKR: clicked Previous") }
                )
            }

             if(firstName.text.isBlank() || lastName.text.isBlank() || mobileNumber.text.isBlank() || emailId.text.isBlank()){
                 isEnabled = false
             }

            item {
                CustomOutlinedTextField(
                    text = emailId,
                    placeHolder = "Email",
                    label = "Email",
                    keyboardType = KeyboardType.Text,
//                    focusRequester = emailFocusRequester,
                    onValueChange = {
                        emailId = it
                    },
                    onDone = {
                        focusManager.clearFocus()
                        isEnabled = firstName.text.isNotBlank() && lastName.text.isNotBlank() && mobileNumber.text.isNotBlank() && emailId.text.isNotBlank()
//                        focusManager.moveFocus(FocusDirection.Down)
                    },
                    onNext = { println("CKR: clicked Next") },
                    onPrevious = { println("CKR: clicked Previous") }
                )
            }

            //Focus Requester is not working for Button
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    enabled = isEnabled,
                    onClick = {  },
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(width = if(isEnabled) 2.dp else 1.dp, color = if(isEnabled) White_Alpha100 else White_Alpha50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = White_Alpha100,
                        disabledContainerColor = disabledColor,
                        disabledContentColor = White_Alpha50
                    ),
                    modifier = Modifier
//                        .focusRequester(submitButtonFocusRequester)
                ) {
                    Text(
                        text = "Submit",
                        modifier = Modifier
                            .padding(horizontal = 40.dp, vertical = 1.dp)
                    )
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    text:TextFieldValue,
    placeHolder:String,
    label:String,
    leadingText:String = "",
    imeAction : ImeAction = ImeAction.Done,
    keyboardType: KeyboardType,
//    focusRequester: FocusRequester,
    onValueChange: (TextFieldValue) -> Unit,
    onDone :() -> Unit,
    onNext :() -> Unit,
    onPrevious :() -> Unit,
){
    OutlinedTextField(
        value = text.text,
        onValueChange = {
            onValueChange(TextFieldValue(it))
        },
        placeholder = {
            Text(text = placeHolder)
        },
        label = {
            Text(text = label)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = KeyboardActions(
            onDone = { onDone() },
            onNext = { onNext() },
            onPrevious = { onPrevious() }
        ),
        modifier = Modifier
            .fillMaxWidth(),
//            .focusRequester(focusRequester),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = White_Alpha100,
            focusedBorderColor = White_Alpha100,
            unfocusedBorderColor = White_Alpha50,
            textColor = White_Alpha100,
            focusedLabelColor = White_Alpha50,
            unfocusedLabelColor = White_Alpha50,
            placeholderColor = White_Alpha50,
            disabledPlaceholderColor = White_Alpha50
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySampleCodesTheme {
        SampleForm()
    }
}