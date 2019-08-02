package com.cleraco.unitconversionapp

import com.cleraco.unitconversionapp.data.Converter
import com.cleraco.unitconversionapp.data.ConverterImpl


import org.junit.Assert
import org.junit.Before
import org.junit.Test

import javax.measure.unit.SI

class TemperatureConvertTest {


    lateinit var converter: Converter

    @Before
    fun setUp(){
       converter = ConverterImpl()
    }
    @Test
    fun calculateTemperatureValue_Success(){

        Assert.assertEquals("126.85",converter.convertTemp(SI.KELVIN,SI.CELSIUS,"400"));
    }

//    @Test
//    fun calculateTemperatureValue_Failure(){
//
//        Assert.assertEquals("156.85",converter.convertTemp(SI.KELVIN,SI.CELSIUS,"400"));
//    }
}