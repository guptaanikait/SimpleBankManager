package org.hyperskill.simplebankmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
     var  corruname:String?=null
     var corrpass:String?=null
     var getBalance:Double?=null
    var emap:Map<String, Map<String, Double>>?=null
    var billmap:Map<String,Triple<String,String,Double>>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         corruname= intent.extras?.getString("username")
         corrpass= intent.extras?.getString("password")
        getBalance= intent.extras?.getDouble("balance")
        emap= intent.extras?.getSerializable("exchangeMap") as Map<String, Map<String, Double>>?
        billmap= intent.extras?.getSerializable("billsMap") as Map<String,Triple<String,String,Double>>?
        if(billmap!=null) {
            Bills.defaultBillInfoMap = billmap!!
        }
        if(emap!=null) {
            ExchangeObj.defaultMap = emap!!
        }

        if(getBalance!=null){
            Balanceobject.balance=getBalance!!
        }
        if(corruname==null){
            corruname="Lara"
        }
        if(corrpass==null){
            corrpass="1234"
        }
        /*override fun doSomething(user:String?,pass:String?) {
            //Log.d("Log", "Doing something!")
            if((user==corruname) && (pass==corrpass)){
                Toast.makeText(this,"logged in",Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(this,"invalid credentials",Toast.LENGTH_SHORT).show()
            }
        }*/
        //val fragment = LoginFragment.newInstance(corruname,corrpass)
        val fragment = LoginFragment()
        val bundle:Bundle? = Bundle()
        bundle?.putString("corruname1", corruname)
        bundle?.putString("corrpass1", corrpass)
        //fragment.arguments = bundle
        //val finalHost = NavHostFragment.create(R.navigation.nav_graph)
        /*supportFragmentManager.commit{
//            add(R.id.nav_host_fragment,fragment)
            add<LoginFragment>(R.id.nav_host_fragment, args = bundle)
        }*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.nav_graph, bundle)




        /*
            Tests for android can not guarantee the correctness of solutions that make use of
            mutation on "static" variables to keep state. You should avoid using those.
            Consider "static" as being anything on kotlin that is transpiled to java
            into a static variable. That includes global variables and variables inside
            singletons declared with keyword object, including companion object.
            This limitation is related to the use of JUnit on tests. JUnit re-instantiate all
            instance variable for each test method, but it does not re-instantiate static variables.
            The use of static variable to hold state can lead to state from one test to spill over
            to another test and cause unexpected results.
            Using mutation on static variables to keep state
            is considered a bad practice anyway and no measure
            attempting to give support to that pattern will be made.
         */
    }

    /*override fun doSomething(user: String?, pass: String?) {
        //TODO("Not yet implemented")
        if((user==corruname) && (pass==corrpass)){
            Toast.makeText(this,"logged in",Toast.LENGTH_SHORT).show()
        }
        else{

            Toast.makeText(this,"invalid credentials",Toast.LENGTH_SHORT).show()
        }
    }*/
}