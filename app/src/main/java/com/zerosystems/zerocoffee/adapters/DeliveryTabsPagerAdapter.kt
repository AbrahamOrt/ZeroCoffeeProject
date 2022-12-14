package com.zerosystems.zerocoffee.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zerosystems.zerocoffee.fragments.delivery.DeliveryOrdersStatusFragment

class DeliveryTabsPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    var numberOfTabs: Int
): FragmentStateAdapter(fragmentManager, lifecycle)
{

    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {

        when(position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("status", "DESPACHADO")
                val fragment = DeliveryOrdersStatusFragment()
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                val bundle = Bundle()
                bundle.putString("status", "EN CAMINO")
                val fragment = DeliveryOrdersStatusFragment()
                fragment.arguments = bundle
                return fragment
            }
            2 -> {
                val bundle = Bundle()
                bundle.putString("status", "ENTREGADO")
                val fragment = DeliveryOrdersStatusFragment()
                fragment.arguments = bundle
                return fragment
            }
            else -> return DeliveryOrdersStatusFragment()
        }

    }

}