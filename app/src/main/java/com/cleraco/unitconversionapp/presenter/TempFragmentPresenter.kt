package com.cleraco.unitconversionapp.presenter

import com.cleraco.unitconversionapp.data.Converter
import com.cleraco.unitconversionapp.data.ConverterImpl
import com.cleraco.unitconversionapp.ui.TempConversionFragment
import javax.measure.quantity.Temperature
import javax.measure.unit.NonSI
import javax.measure.unit.SI
import javax.measure.unit.Unit

class TempFragmentPresenter(
    private val view : TempConversionFragment
) : BasePresenter{
    private var converter: Converter
    init {
        converter = ConverterImpl()


    }
    override fun calculateValue(intUnit1 : Int?, intUnit2 : Int?, inputValue : String){

        val inputUnit : Unit<Temperature>?  = getUnitType(intUnit1)
        val outputUnit : Unit<Temperature>? = getUnitType(intUnit2)

        val result = converter.convertTemp(inputUnit!!,outputUnit!!,inputValue)

        view.conversionResult("${result}")
    }

    private fun getUnitType(pos: Int?) : Unit<Temperature>?{

        val tempUnit = when (pos) {
            0 -> SI.KELVIN
            1 -> SI.CELSIUS
            2 -> NonSI.FAHRENHEIT
            3 -> (SI.CELSIUS.plus(100.0).times(2.0)).divide(3.0).times(-1)
            else -> null
            }

        return tempUnit
    }




}