package org.hyperskill.simplebankmanager

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 * Use the [TransferFundsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class TransferFundsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    /*private var param1: String? = null
    private var param2: String? = null*/
    private var etaccount: EditText?=null
    private var etamount: EditText?=null
    private var button: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
    }
    fun String.numberAsCurrencyFormat(currencySymbol: String = "$"): String {
        return this.toDouble().asCurrencyFormat(currencySymbol)
    }

    fun Double.asCurrencyFormat(currencySymbol: String = "$"): String {
        return "$currencySymbol%.2f".format(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_funds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etaccount=view.findViewById(R.id.transferFundsAccountEditText)
        etamount=view.findViewById(R.id.transferFundsAmountEditText)
        button=view.findViewById(R.id.transferFundsButton)

        button?.setOnClickListener {
            if(TextUtils.isEmpty(etaccount?.text.toString())){
                etaccount?.error="Invalid account number"
            }
            if(TextUtils.isEmpty(etamount?.text.toString())){
                etamount?.error="Invalid amount"
            }
            else if(!TextUtils.isEmpty(etaccount?.text.toString()) && !TextUtils.isEmpty(etamount?.text.toString())) {
                var account: String = etaccount?.text.toString()
                var amount: String = etamount?.text.toString()
                val pattern: String = "[sc]a\\d{4}"
                //val input = "sc1234"
                val isMatch = amount.isNotEmpty() and Regex(pattern).matches(account)
                val isMatch1 = amount.isNotEmpty() and ((amount.toDouble()) > 0.0)
                if (!isMatch) {
                    etaccount?.error = "Invalid account number"
                }
                if (!isMatch1) {
                    etamount?.error = "Invalid amount"
                }
                if (isMatch && isMatch1) {
                    //Toast.makeText(context,"Transfer successful",Toast.LENGTH_SHORT).show()
                    if (amount.toDouble() > Balanceobject.balance) {
                        Toast.makeText(
                            context,
                            "Not enough funds to transfer ${amount.numberAsCurrencyFormat()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (amount.toDouble() <= Balanceobject.balance) {
                        Toast.makeText(
                            context,
                            "Transferred ${amount.numberAsCurrencyFormat()} to account ${account}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Balanceobject.balance -= amount.toDouble()
                        findNavController().navigate(R.id.userMenuFragment)
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
         * @return A new instance of fragment TransferFundsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransferFundsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}