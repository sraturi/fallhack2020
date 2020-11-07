package com.example.fallhack2020.model

data class SignUpForm(var firstName:String = "") {
    var lastName:String = ""
    var phoneNumber:String = ""
    var dateOfBirth: String = ""

    fun isEverythingFilled(): Boolean {
        if (firstName == "" || lastName == "" || phoneNumber== "" || dateOfBirth== "") {
            return false
        }
        return true
    }
}