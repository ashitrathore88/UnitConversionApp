package com.cleraco.unitconversionapp.data

import javax.measure.quantity.Temperature
import javax.measure.quantity.Volume
import javax.measure.unit.Unit

interface Converter {

    fun convertTemp(unit1 : Unit<Temperature>, unit2 : Unit<Temperature>, value : String) : String

    fun convertVolume(unit1 : Unit<Volume>, unit2 : Unit<Volume>, value : String) : String
}