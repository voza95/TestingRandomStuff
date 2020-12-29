package com.example.testingrandomstuff.fragment.first

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.testingrandomstuff.R
import kotlinx.android.synthetic.main.first_screen_fragment.*

class FirstScreenFragment : Fragment() {

    companion object {
        fun newInstance() = FirstScreenFragment()
    }

    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_screen_fragment, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstScreenViewModel::class.java)

        var bundle = Bundle()
        bundle.putBoolean("test_boolean", true)

        /*var s = Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment)
        button_frag1.setOnClickListener(s)*/

        var navController = activity?.let { Navigation.findNavController(it, R.id.my_nav_host_fragment) }
        button_frag1.setOnClickListener {
            navController?.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

        button_list1.setOnClickListener {
            navController?.navigate(R.id.action_firstFragment_to_fourthFragment)
        }
    }

}