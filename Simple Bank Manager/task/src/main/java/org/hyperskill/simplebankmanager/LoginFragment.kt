package org.hyperskill.simplebankmanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(){//View.OnClickListener {
    // TODO: Rename and change types of parameters
    //private var param1: String? = null
    //private var param2: String? = null
    private var username1:EditText?=null
    private var password:EditText?=null
    private var button: Button?=null
    var corruname:String?=null
    var corrpass:String?=null
    //private var callback: YourFragmentListener? = null
    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as YourFragmentListener
    }
    override fun onDetach() {
        super.onDetach()
        callback = null
    }*/
    //val intent = (view?.context as AppCompatActivity).intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        corruname=bundle?.getString("corruname1")
        corrpass=bundle?.getString("corrpass1")
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/

        //username?.setText(corruname)
        //password?.setText(corrpass)


            /*var name:String=username1?.text.toString()
            var pass:String=password?.text.toString()
            if((name==corruname) && (pass==corrpass)){
                Toast.makeText(context,"logged in",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context,"invalid credentials",Toast.LENGTH_SHORT).show()
            }*
        }*/

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_login, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username1=view.findViewById(R.id.loginUsername)
        password=view.findViewById(R.id.loginPassword)
        button=view.findViewById(R.id.loginButton)

        /*val intent:Intent? = (view.context as AppCompatActivity).intent
        var corruname:String?= intent?.extras?.getString("username")
        var corrpass:String?= intent?.extras?.getString("password")
        if(corruname==null){
            corruname="Lara"
        }
        if(corrpass==null){
            corrpass="1234"
        }*/

        button?.setOnClickListener {
            var name:String?=username1?.text.toString()
            var pass:String?=password?.text.toString()
            if((name==corruname) && (pass==corrpass)){

                //val bundle = Bundle()
               // bundle.putString("Key",name)
                Name.name=name!!
                findNavController().navigate(R.id.userMenuFragment)
                Toast.makeText(context,"logged in",Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(context,"invalid credentials",Toast.LENGTH_SHORT).show()
            }
            //callback?.doSomething(name,pass)
        }

    }
    /*interface YourFragmentListener {
        fun doSomething(user:String?,pass:String?)
    }*/
    /*override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginButton -> {
                //toast("alpjasjdkasndknaskdnkasndkasndkjnaskjdnaskjdnkasjndkas")
                var name:String?=username1?.text.toString()
                var pass:String?=password?.text.toString()
                if((name==corruname) && (pass==corrpass)){
                    Toast.makeText(context,"logged in",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context,"invalid credentials",Toast.LENGTH_SHORT).show()
                }
            }

            else -> {
            }
        }
    }*/

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        //fun newInstance(param1: String, param2: String) =

                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
     // }*/
}