package com.cleraco.unitconversionapp

import com.cleraco.unitconversionapp.data.Converter
import com.cleraco.unitconversionapp.data.ConverterImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.measure.unit.NonSI
import javax.measure.unit.SI

class VolumeConvertTest {

    lateinit var converter: Converter

    @Before
    fun setUp(){
        converter = ConverterImpl()
    }

    @Test
    fun calculateVolumeValue_Success(){

        Assert.assertEquals("7.9252",converter.convertVolume(NonSI.LITRE, NonSI.GALLON_LIQUID_US,"30"));
    }
}