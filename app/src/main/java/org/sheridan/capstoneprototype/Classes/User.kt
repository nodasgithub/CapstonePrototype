package org.sheridan.capstoneprototype.Classes

class User {


    var id: Int = 0
    var userName: String? = null
    var email: String? = null


    constructor(userName: String?, email: String?) {
        this.userName = userName
        this.email = email
    }
}