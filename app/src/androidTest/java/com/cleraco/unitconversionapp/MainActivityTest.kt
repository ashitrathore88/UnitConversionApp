package com.cleraco.unitconversionapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf
import org.hamcrest.core.IsAnything
import org.hamcrest.core.StringContains
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Test
    fun testTemperatureConversionSuccessful(){

        onView(withId(R.id.temp_converter_btn)).perform(click());
        onView(withId(R.id.txtinput_unit)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.input_unit_spinner)).perform(click());
        onData(IsAnything.anything()).atPosition(0).perform(click())
        onView(withId(R.id.output_unit_spinner)).perform(click());
        onData(IsAnything.anything()).atPosition(1).perform(click())

        onView(withId(R.id.input_value_txt)).perform(ViewActions.clearText())
            .perform(ViewActions.typeText("400"), closeSoftKeyboard())
        onView(withId(R.id.submit_btn)).perform(click());
        onView(withId(R.id.output_value_txt))
            .check(ViewAssertions.matches(withText(StringContains.containsString("126.85"))))

        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

    }
    @Test
    fun testVolumeConversionSuccessful(){
        onView(withId(R.id.vol_converter_btn)).perform(click());
        onView(withId(R.id.txt_input_vol)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.input_unit_spinner)).perform(click());
        onData(IsAnything.anything()).atPosition(0).perform(click())
        onView(withId(R.id.output_unit_spinner)).perform(click());
        onData(IsAnything.anything()).atPosition(2).perform(click())

        onView(withId(R.id.input_value_txt)).perform(ViewActions.clearText())
            .perform(ViewActions.typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.submit_btn)).perform(click());
        onView(withId(R.id.output_value_txt))
            .check(ViewAssertions.matches(withText(StringContains.containsString("7.92"))))
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

    }


}