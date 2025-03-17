package org.hyperskill.simplebankmanager

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 * Use the [CalculateExchangeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculateExchangeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    /*private var param1: String? = null
    private var param2: String? = null*/
    fun String.numberAsCurrencyFormat(currencySymbol: String = "$"): String {
        return this.toDouble().asCurrencyFormat(currencySymbol)
    }

    fun Double.asCurrencyFormat(currencySymbol: String = "$"): String {
        return "$currencySymbol%.2f".format(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculate_exchange, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner1=view.findViewById<Spinner>(R.id.calculateExchangeFromSpinner)
        val spinner2=view.findViewById<Spinner>(R.id.calculateExchangeToSpinner)
        var edittext1=view.findViewById<EditText>(R.id.calculateExchangeAmountEditText)
        val button1=view.findViewById<Button>(R.id.calculateExchangeButton)
        var textview1=view.findViewById<TextView>(R.id.calculateExchangeDisplayTextView)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currencies,
            //listOf("EUR", "GBP", "USD")
            android.R.layout.simple_spinner_item
            //listOf("EUR", "GBP", "USD")
            //listOf("EUR", "GBP", "USD")
        ).also{ adapter ->
            // Set the layout for the drop down list
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Apply the adapter to the spinner
            spinner1.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currencies,
            //listOf("EUR", "GBP", "USD")
            android.R.layout.simple_spinner_item
            //listOf("EUR", "GBP", "USD")
            //listOf("EUR", "GBP", "USD")
        ).also{ adapter ->
            // Set the layout for the drop down list
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }
        val listener1 = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                // We retrieve the selected item from the Spinner via its position in list
                var selectedItem = parent.getItemAtPosition(pos)
                if(selectedItem.toString()==ExchangeObj.tocurr){
                    Toast.makeText(context,"Cannot convert to same currency",Toast.LENGTH_SHORT).show()
                    selectedItem=parent.getItemAtPosition((pos+1)%3)
                    spinner1.setSelection((pos+1)%3)
                }
                ExchangeObj.fromcurr=selectedItem.toString()

                // Show toast with selected item


            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                ExchangeObj.fromcurr=""
                //This method will be invoked when the selection disappears from the view

            }
        }
        spinner1.onItemSelectedListener = listener1
        val listener2 = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                // We retrieve the selected item from the Spinner via its position in list
                var selectedItem = parent.getItemAtPosition(pos)
                if(selectedItem.toString()==ExchangeObj.fromcurr){
                    Toast.makeText(context,"Cannot convert to same currency",Toast.LENGTH_SHORT).show()
                    selectedItem=parent.getItemAtPosition((pos+1)%3)
                    spinner2.setSelection((pos+1)%3)
                }
                ExchangeObj.tocurr=selectedItem.toString()

                // Show toast with selected item


            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                ExchangeObj.tocurr=""
                //This method will be invoked when the selection disappears from the view

            }
        }
        spinner2.onItemSelectedListener = listener2
        button1.setOnClickListener {
            if(TextUtils.isEmpty(edittext1.text.toString())){
                Toast.makeText(context,"Enter amount",Toast.LENGTH_SHORT).show()
            }
            else{
                val h1=edittext1.text.toString().toDouble()
                val h2=h1*ExchangeObj.defaultMap[ExchangeObj.fromcurr]!![ExchangeObj.tocurr]!!
                val h3=String.format("%.2f", h1)
                val h4=String.format("%.2f", h2)

                if(ExchangeObj.fromcurr=="EUR"){
                    if(ExchangeObj.tocurr=="GBP"){
                        textview1.setText("€"+h3+" = "+"£"+h4)
                    }
                    else if(ExchangeObj.tocurr=="USD"){
                        //textview1.setText("€${h3} = $${h4}")
                        textview1.setText("€"+h3+" = "+"$"+h4)


                    }
                }
                else if(ExchangeObj.fromcurr=="GBP"){
                    if(ExchangeObj.tocurr=="EUR"){
                        //textview1.setText("£${h3} = €${h4}")
                        textview1.setText("£"+h3+" = "+"€"+h4)
                    }
                    else if(ExchangeObj.tocurr=="USD") {
                        //textview1.setText("£${h3} = $${h4}")
                        textview1.setText("£"+h3+" = "+"$"+h4)
                    }
                }
                else if(ExchangeObj.fromcurr=="USD"){
                    if(ExchangeObj.tocurr=="EUR"){
                        //textview1.setText("$${h3} = €${h4}")
                        textview1.setText("$"+h3+" = "+"€"+h4)
                    }
                    else if(ExchangeObj.tocurr=="GBP"){
                        //textview1.setText("$${h3} = £${h4}")
                        textview1.setText("$"+h3+" = "+"£"+h4)
                    }
                }
            }
        }



    }



    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalculateExchangeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalculateExchangeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}