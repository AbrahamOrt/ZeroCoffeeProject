package com.zerosystems.zerocoffee.activities.restaurant.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.zerosystems.zerocoffee.R
import com.zerosystems.zerocoffee.activities.MainActivity
import com.zerosystems.zerocoffee.fragments.client.ClientProfileFragment
import com.zerosystems.zerocoffee.fragments.restaurant.RestaurantCategoryFragment
import com.zerosystems.zerocoffee.fragments.restaurant.RestaurantOrdersFragment
import com.zerosystems.zerocoffee.fragments.restaurant.RestaurantProductFragment
import com.zerosystems.zerocoffee.models.User
import com.zerosystems.zerocoffee.providers.UsersProvider
import com.zerosystems.zerocoffee.utils.SharedPref

class RestaurantHomeActivity : AppCompatActivity() {

    private val TAG = "RestaurantHomeActivity"
    //    var buttonLogout: Button? = null
    var sharedPref: SharedPref? = null
    var usersProvider: UsersProvider? = null
    var user: User? = null
    var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_home)
        sharedPref = SharedPref(this)
//        buttonLogout = findViewById(R.id.btn_logout)
//        buttonLogout?.setOnClickListener { logout() }

        openFragment(RestaurantOrdersFragment())

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation?.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.item_home -> {
                    openFragment(RestaurantOrdersFragment())
                    true
                }

                R.id.item_category -> {
                    openFragment(RestaurantCategoryFragment())
                    true
                }

                R.id.item_product -> {
                    openFragment(RestaurantProductFragment())
                    true
                }

                R.id.item_profile -> {
                    openFragment(ClientProfileFragment())
                    true
                }

                else -> false

            }

        }

        getUserFromSession()
        usersProvider = UsersProvider(token = user?.sessionToken!!)
        createToken()
    }

    private fun createToken() {
        usersProvider?.createToken(user!!,this)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun logout() {
        sharedPref?.remove("user")
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun getUserFromSession() {

        val gson = Gson()

        if (!sharedPref?.getData("user").isNullOrBlank()) {
            // SI EL USARIO EXISTE EN SESION
            user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
            Log.d(TAG, "Usuario: $user")
        }

    }
}