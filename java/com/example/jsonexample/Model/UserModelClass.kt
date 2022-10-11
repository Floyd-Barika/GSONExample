package com.example.jsonexample.Model

data class Users(
    val users:MutableList<UserModelClass>
)

data class UserModelClass (
    val id:Int,
    val name:String,
    val email:String,
    val gender:String,
    val weight:Double,
    val height:Int,
    val phone:Phone
)

data class Phone(
    val mobileNumber:String,
    val officeNumber:String
)