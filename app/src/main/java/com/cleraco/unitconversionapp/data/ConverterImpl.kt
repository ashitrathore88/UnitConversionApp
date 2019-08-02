package com.cleraco.unitconversionapp.data

import javax.measure.converter.UnitConverter
import javax.measure.quantity.Temperature
import javax.measure.quantity.Volume
import javax.measure.unit.Unit

class ConverterImpl : Converter {
    override fun convertTemp(unit1: Unit<Temperature>, unit2: Unit<Temperature>, value: String): String {
        var unitConverter : UnitConverter? = unit1?.getConverterTo(unit2)
        var result = String.format("%.2f",unitConverter!!.convert(value.toDouble()))

        return result
    }

    override fun convertVolume(unit1: Unit<Volume>, unit2: Unit<Volume>, value: String): String {
        var unitConverter : UnitConverter? = unit1?.getConverterTo(unit2)
        var result = String.format("%.4f",unitConverter!!.convert(value.toDouble()))
        return result
    }
}