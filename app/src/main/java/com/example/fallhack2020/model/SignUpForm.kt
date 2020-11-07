package com.example.fallhack2020.model

data class SignUpForm(var firstName:String = "") {
    var lastName:String = ""
    var phoneNumber:String = ""
    var dateOfBirth: String = ""
    var email:String = ""
    var password:String = ""

    fun isEverythingFilled(): Boolean {
        if (firstName == "" || lastName == "" || phoneNumber== ""  || email ==""|| password == "") {
            return false
        }
        return true
    }
}