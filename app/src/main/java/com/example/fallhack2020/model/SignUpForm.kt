package com.example.fallhack2020.model

data class SignUpForm(var confirmPassword:String = "") {

    var email:String = ""
    var password:String = ""

    fun isEverythingFilled(): Boolean {
        if (confirmPassword == ""|| email ==""|| password == "") {
            return false
        }
        if (confirmPassword != password) {
            return false
        }
        return true
    }
}