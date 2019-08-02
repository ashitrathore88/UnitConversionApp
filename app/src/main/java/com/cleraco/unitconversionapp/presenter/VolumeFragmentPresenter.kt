package com.cleraco.unitconversionapp.presenter

import com.cleraco.unitconversionapp.data.Converter
import com.cleraco.unitconversionapp.data.ConverterImpl
import com.cleraco.unitconversionapp.ui.VolumeConversionFragment
import javax.measure.converter.UnitConverter
import javax.measure.quantity.Temperature
import javax.measure.quantity.Volume
import javax.measure.unit.NonSI
import javax.measure.unit.SI
import javax.measure.unit.Unit

class VolumeFragmentPresenter(
    private val view : VolumeConversionFragment
) : BasePresenter{
    private lateinit var converter: Converter
    init {
        converter = ConverterImpl()
    }

    override fun calculateValue(intUnit1: Int?, intUnit2: Int?, inputValue: String) {
        val inputUnit : Unit<Volume>?  = getUnitType(intUnit1)
        val outputUnit : Unit<Volume>? = getUnitType(intUnit2)

        var result = converter.convertVolume(inputUnit!!,outputUnit!!,inputValue);
        view.conversionResult("${result}")
    }

    private fun getUnitType(pos: Int?) : Unit<Volume>?{

        var volUnit = when (pos) {
            0 -> NonSI.LITRE
            1 -> SI.MILLI(NonSI.LITER)
            2 -> NonSI.GALLON_LIQUID_US
            else -> null
        }

        return volUnit
    }
}