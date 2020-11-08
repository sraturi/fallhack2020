package com.example.fallhack2020.data

import java.io.Serializable

data class Item (
    var name: String? = "",
    var description: String? = "",
    var price: Double = 0.00,
    var streetAddress: String = "",
    var city: String = "",
    var postalCode: String = "",
    var category: String = "",
    var phone: String = ""
) :Serializable{
    override fun toString(): String {
        return "Item(name=$name, description=$description, price=$price, streetAddress='$streetAddress', city='$city', postalCode='$postalCode', category='$category', phone='$phone')"
    }
}