package com.example.mysamplecodes.SampleScreens

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Wc
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.ui.theme.Brown
import com.example.mysamplecodes.ui.theme.Green
import com.example.mysamplecodes.ui.theme.MySampleCodesTheme
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.White_Alpha50
import com.example.mysamplecodes.ui.theme.disabledColor
import com.example.mysamplecodes.ui.theme.verticalGradient
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun SampleForm(){
    var firstName by remember { mutableStateOf( TextFieldValue(""))}
    var lastName by remember { mutableStateOf( TextFieldValue(""))}
    val countryCode = "+91 "
    var mobileNumber by remember { mutableStateOf( TextFieldValue(""))}
    var gender by remember { mutableStateOf( TextFieldValue(""))}
    var dateOfBirth by remember { mutableStateOf( TextFieldValue(""))}
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
                .padding(top = 40.dp)
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
                    leadingIcon = Icons.Filled.Person,
                    trailingIcon = Icons.Filled.Air,
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
                    leadingIcon = Icons.Filled.Person,
                    trailingIcon = Icons.Filled.Air,
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
                    leadingIcon = Icons.Filled.PhoneAndroid,
                    trailingIcon = Icons.Filled.Air,
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

            item {
                CustomOutlinedTextField(
                    isReadOnly = true,
                    text = gender,
                    placeHolder = "Select Gender from List",
                    label = "Gender",
                    leadingIcon = Icons.Filled.Wc,
                    trailingIcon = Icons.Filled.ArrowDropDown,
                    dropDownList = listOf("Male", "Female"),
                    keyboardType = KeyboardType.Phone,
//                    focusRequester = mobileFocusRequester,
                    onValueChange = {
                        focusManager.moveFocus(FocusDirection.Down)
                        gender = it
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

            item {
                CustomOutlinedTextField(
                    isReadOnly = true,
                    text = dateOfBirth,
                    placeHolder = "Date of Birth",
                    label = "Date of Birth",
                    leadingIcon = Icons.Filled.CalendarMonth,
                    trailingIcon = Icons.Filled.EditCalendar,
                    keyboardType = KeyboardType.Phone,
//                    focusRequester = mobileFocusRequester,
                    onValueChange = {
                        focusManager.moveFocus(FocusDirection.Down)
                        dateOfBirth = it
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
                    leadingIcon = Icons.Filled.Email,
                    trailingIcon = Icons.Filled.Air,
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
    isReadOnly:Boolean = false,
    text:TextFieldValue,
    placeHolder:String,
    label:String,
    dropDownList:List<String> = emptyList(),
    leadingIcon : ImageVector,
    trailingIcon : ImageVector,
    imeAction : ImeAction = ImeAction.Done,
    keyboardType: KeyboardType,
//    focusRequester: FocusRequester,
    onValueChange: (TextFieldValue) -> Unit,
    onDone :() -> Unit,
    onNext :() -> Unit,
    onPrevious :() -> Unit,
){
    var expandGender by remember {
        mutableStateOf(false)
    }
    var expandCalendar by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        enabled = true,
        readOnly = isReadOnly,
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
        leadingIcon = {
             Icon(
                 imageVector = leadingIcon,
                 contentDescription = "",
                 tint = White_Alpha50
             )
        },
        trailingIcon = {
            if(label == "Gender" || label == "Date of Birth")
            Icon(
                imageVector = trailingIcon,
                contentDescription = "",
                tint = White_Alpha50,
                modifier = Modifier.clickable {
                    when(label){
                        "Gender" -> {
                            expandGender = !expandGender
                        }
                        "Date of Birth" -> {
                            expandCalendar = !expandCalendar
                        }
                    }
                }
            )
            if(expandGender && dropDownList.isNotEmpty()){
                DropdownMenu(
                    modifier = Modifier
//                        .background(Green)
                        .background(Brown)
                        .border(width = Dp.Hairline, color = White_Alpha100),
                    expanded = expandGender,
                    onDismissRequest = { expandGender = false },
                    offset = DpOffset.Zero,
                ) {
                    dropDownList.forEach { item ->
                        DropdownMenuItem(
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp),
                            onClick = {
                                onValueChange(TextFieldValue(item))
                                expandGender = false
                            },
                            text = {
                                Text(
                                    text = item,
                                    color = White_Alpha100
                                )
                            }
                        )
                    }
                }
            }

            if(expandCalendar){
                val minDateInLong = Calendar.getInstance().run {
                    add(
                        Calendar.DATE,
                        2
                    )
                    time
                }.time
//                MaterialDatePicker(
//                    title = "Select Date",
//                    setEndDate = System.currentTimeMillis(),
//                    onDismiss = {
//                        expandCalendar = !expandCalendar
//                    }
//                )
//                CustomDatePicker(
//                    show = expandCalendar,
//                    onDateChanged = { date ->
//                        onValueChange(TextFieldValue(date))
//                        expandCalendar = !expandCalendar
//                    },
//                    dateFormat = "yyyy-MM-dd",
//                    minDate = null,
//                    maxDate = System.currentTimeMillis(),
//                    onCancel = {
//                        expandCalendar = !expandCalendar
//                    },
//                )
                M3DatePicker(
                    title = "Select Date",
                    setEndDate = System.currentTimeMillis(),
                    onDateChanged = { date ->
                        onValueChange(TextFieldValue(date))
                        expandCalendar = !expandCalendar
                    },
                    onDismiss = {
                        expandCalendar = !expandCalendar
                    }
                )
            }
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
        colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = White_Alpha100,
            focusedBorderColor = White_Alpha100,
            unfocusedBorderColor = White_Alpha50,
//            textColor = White_Alpha100,
            focusedLabelColor = White_Alpha50,
            unfocusedLabelColor = White_Alpha50,
//            placeholderColor = White_Alpha50,
            disabledPlaceholderColor = White_Alpha50,
            focusedTextColor = White_Alpha100,
            focusedPlaceholderColor = White_Alpha50,
            unfocusedTextColor = White_Alpha100
        )
    )
}

@SuppressLint("SimpleDateFormat")
@Composable
fun CustomDatePicker(show:Boolean,
                       onDateChanged:(String) -> Unit,
                       dateFormat:String = "yyyy-MM-dd",
                       minDate:Long? = null,
                       maxDate:Long? = null,
                       onCancel:() -> Unit
){
    val dateNow: LocalDate = LocalDate.now()
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            onDateChanged(
                SimpleDateFormat(dateFormat).format(SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.of(year, month + 1, dayOfMonth).toString()))
            )
        },
        dateNow.year,
        dateNow.monthValue - 1,
        dateNow.dayOfMonth,
    )

    minDate?.let{
        datePickerDialog.datePicker.minDate = it
    }
    maxDate?.let{
        datePickerDialog.datePicker.maxDate = it
    }
    datePickerDialog.setOnCancelListener {
        onCancel()
    }

    if(show) datePickerDialog.show()
}

@OptIn(ExperimentalMaterial3Api::class)
object PastOrPresentSelectableDates: SelectableDates {
    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        return utcTimeMillis <= System.currentTimeMillis() // <= will give past dates and >= gives future dates.
    }

    override fun isSelectableYear(year: Int): Boolean {
        return year <= LocalDate.now().year
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3DatePicker(
    title:String,
    format:String = "MM-dd-yyyy",
    setStartDate:Long? = null,
    setEndDate:Long? = null,
    onDateChanged:(String) -> Unit,
    onDismiss:() -> Unit
){
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        initialDisplayedMonthMillis = setEndDate,
//        yearRange = IntRange(2024,2030),
        selectableDates = PastOrPresentSelectableDates
    )
    datePickerState.selectedDateMillis = setEndDate

    val enabled = derivedStateOf { datePickerState.selectedDateMillis != null }

    androidx.compose.material3.DatePickerDialog(
        onDismissRequest = { onDismiss()},
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                },
                enabled = enabled.value
            ) {
                Text(
                    text = "Cancel",
                    color = White_Alpha100
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    datePickerState.selectedDateMillis?.let { dateinMillis ->
                        onDateChanged(DateLongToStringConvert(format = format, dateInMillis = dateinMillis))
                    }
                },
                enabled = enabled.value
            ) {
                Text(
                    text = "OK",
                    color = White_Alpha100
                )
            }
        },
        colors = DatePickerDefaults.colors(
//            containerColor = Green,
            containerColor = Brown,
        ),
    ){
        DatePicker(
            state = datePickerState,
//            dateFormatter = DatePickerDefaults.dateFormatter("dd-MM-yyyy"), //this will change menu yeat selection.
            colors = DatePickerDefaults.colors(
//                containerColor = Green,
                containerColor = Brown,
                titleContentColor = White_Alpha100,
                headlineContentColor = White_Alpha100,
                weekdayContentColor = White_Alpha100,
                selectedDayContainerColor = White_Alpha100,
//                selectedDayContentColor = Green,
                selectedDayContentColor = Brown,
                navigationContentColor = White_Alpha100,
                dayContentColor = White_Alpha100,
                todayDateBorderColor = White_Alpha100,
                todayContentColor = White_Alpha100,
//                selectedYearContentColor = Green,
                selectedYearContentColor = Brown,
                selectedYearContainerColor = White_Alpha100,
                yearContentColor = White_Alpha100,
                currentYearContentColor = White_Alpha100,
                dateTextFieldColors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = White_Alpha100,
                    unfocusedTextColor = White_Alpha100,
                    focusedLabelColor = White_Alpha50,
                    unfocusedLabelColor = White_Alpha50,
                    focusedPlaceholderColor = White_Alpha50,
                    unfocusedPlaceholderColor = White_Alpha50,
                    cursorColor = White_Alpha100,
                    focusedIndicatorColor = White_Alpha100,
                    unfocusedIndicatorColor = White_Alpha100

                )
            ),
        )
    }
}

fun DateLongToStringConvert(format:String,dateInMillis: Long): String{
    // Sample long value representing a date in milliseconds
//    val dateInMillis: Long = 1644998400000 // Example: February 17, 2022

    // Create a Date object from the long value
    val date = Date(dateInMillis)

    // Create a SimpleDateFormat object to format the date "yyyy-MM-dd HH:mm:ss"
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())

    // Convert the Date object to a formatted date string
    return dateFormat.format(date)
}

//This below MaterialDatePicker is not for compose and it is for native android.
@Composable
fun MaterialDatePicker(
    title:String,
    setStartDate:Long? = null,
    setEndDate:Long? = null,
    onDismiss:() -> Unit
){
    val activity = LocalContext.current as AppCompatActivity
    val constraintsBuilder = CalendarConstraints.Builder()
    setStartDate?.let { startDate ->
        constraintsBuilder.setStart(startDate)
    }
    setEndDate?.let { endDate ->
        constraintsBuilder.setEnd(endDate)
    }

    val datePicker = MaterialDatePicker.Builder.datePicker()
        .setTitleText(title)
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
        .setCalendarConstraints(constraintsBuilder.build())
        .build()

    datePicker.addOnDismissListener {
        onDismiss()
    }

    datePicker.show(activity.supportFragmentManager, title)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySampleCodesTheme {
        SampleForm()
    }
}