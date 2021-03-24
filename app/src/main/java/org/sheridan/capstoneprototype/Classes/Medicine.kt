package org.sheridan.capstoneprototype.Classes

class Medicine {

    var id: Int = 0
    var medName: String? = null
    var dosage: Int = 0
    var frequency: Int = 0
    var quantity: Int = 0
    var description: String? = null


    constructor(
        medName: String?,
        dosage: Int,
        frequency: Int,
        quantity: Int,
        description: String?
    ) {
        this.medName = medName
        this.dosage = dosage
        this.frequency = frequency
        this.quantity = quantity
        this.description = description
    }


}