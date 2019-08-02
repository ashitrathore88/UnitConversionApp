package com.cleraco.unitconversionapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.cleraco.unitconversionapp.R
import com.cleraco.unitconversionapp.presenter.TempFragmentPresenter
import kotlinx.android.synthetic.main.fragment_temp_conversion.*


/**
 * A simple [Fragment] subclass.
 *
 */
class TempConversionFragment : Fragment() , BaseView{

    private lateinit var tempFragPresenter : TempFragmentPresenter
    private var inputUnitPosition : Int? = null
    private var outputUnitPosition : Int? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temp_conversion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tempFragPresenter = TempFragmentPresenter(this)
        setUpView()

    }

    override fun conversionResult(result: String) {
        output_value_txt.text = result
    }


    private fun setUpView(){

        ArrayAdapter.createFromResource(
            this.context,
            R.array.temp_unit_array,
            android.R.layout.simple_spinner_item
        ).also {adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            input_unit_spinner.adapter = adapter
            output_unit_spinner.adapter = adapter
        }

        input_unit_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               // Toast.makeText(this@TempConversionFragment.context, "Position ${position}", Toast.LENGTH_LONG).show()
                inputUnitPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        output_unit_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                outputUnitPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        submit_btn.setOnClickListener {
            if(inputUnitPosition != null && outputUnitPosition != null && input_value_txt.text.toString().length > 0)
                tempFragPresenter.calculateValue(inputUnitPosition,outputUnitPosition,input_value_txt.text.toString())
            else
                Toast.makeText(this@TempConversionFragment.context, "Please enter a value and select Input/Output unit", Toast.LENGTH_LONG).show()
        }
    }

}
