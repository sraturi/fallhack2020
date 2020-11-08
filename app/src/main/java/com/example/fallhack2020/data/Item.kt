package com.example.fallhack2020.data

data class Item (
    var name: String? = "",
    var description: String? = "",
    var price: Double = 0.00,
    var streetAddress: String = "",
    var city: String = "",
    var postalCode: String = "",
    var category: String = "",
    var phone: String = ""
)