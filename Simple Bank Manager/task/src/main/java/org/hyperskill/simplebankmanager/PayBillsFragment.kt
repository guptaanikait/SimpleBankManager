package org.hyperskill.simplebankmanager

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PayBillsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PayBillsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    /*private var param1: String? = null
    private var param2: String? = null*/

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
        return inflater.inflate(R.layout.fragment_pay_bills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button1=view.findViewById<Button>(R.id.payBillsShowBillInfoButton)
        val et1=view.findViewById<EditText>(R.id.payBillsCodeInputEditText)
        button1.setOnClickListener {
            val code=et1.text.toString()
            if(code.isEmpty() || Bills.defaultBillInfoMap[code]==null){
                AlertDialog.Builder(context)
                    .setTitle("Error ")
                    .setMessage("Wrong code")
                    .setPositiveButton(android.R.string.ok) { _, _ ->
                        //Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                        //null
                    }
                    //.setNegativeButton(android.R.string.cancel, null)
                    .show()
            }
            else{
                val bill=Bills.defaultBillInfoMap[code]
                val alh=AlertDialog.Builder(context)
                    .setTitle("Error ")
                    .setMessage("Not enough funds")
                    .setPositiveButton(android.R.string.ok) { _, _ ->
                        //Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                        //null
                    }
                    //.setNegativeButton(android.R.string.cancel, null)
                    //.show()
                AlertDialog.Builder(context)
                    .setTitle("Bill info")
                    .setMessage("Name: ${Bills.defaultBillInfoMap[code]?.first}\n" +
                            "BillCode: ${Bills.defaultBillInfoMap[code]?.second}\n" +
                            "Amount: ${String.format("%.2f",Bills.defaultBillInfoMap[code]?.third)}\$")
                    .setPositiveButton("CONFIRM") { _, _ ->
                        //Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                        if(Balanceobject.balance>=Bills.defaultBillInfoMap[code]?.third!!){
                            Toast.makeText(context,"Payment for bill ${Bills.defaultBillInfoMap[code]?.first}, was successful",
                                Toast.LENGTH_SHORT).show()
                            Balanceobject.balance-=Bills.defaultBillInfoMap[code]?.third!!

                        }
                        else{
                            //this.cancel()
                            alh.show()

                        }
                    }
                    .setNegativeButton(android.R.string.cancel, null)
                    .show()

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
         * @return A new instance of fragment PayBillsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PayBillsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}