package com.example.testingrandomstuff.fragment.second

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.Navigation
import com.example.testingrandomstuff.R
import com.example.testingrandomstuff.fragment.first.FirstScreenFragmentArgs
import kotlinx.android.synthetic.main.second_screen_fragment.*

class SecondScreenFragment : Fragment() {

    companion object {
        fun newInstance() = SecondScreenFragment()
    }

    private lateinit var viewModel: SecondScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_screen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondScreenViewModel::class.java)

        Toast.makeText(activity?.applicationContext, "Bundle args 1 " + arguments?.getBoolean("test_boolean"), Toast.LENGTH_SHORT).show()
        Toast.makeText(activity?.applicationContext, "Bundle args 2 " + arguments?.let {
            FirstScreenFragmentArgs.fromBundle(
                it
            ).testSting
        }, Toast.LENGTH_SHORT).show()



        button_frag2.setOnClickListener {
            var navController = activity?.let { it1 -> Navigation.findNavController(it1,R.id.my_nav_host_fragment) }
            navController?.navigateUp()
            navController?.addOnDestinationChangedListener { controller, destination, arguments ->
                Log.d("TAG", destination.label.toString())

            }
        }

        activity?.let {
            requireActivity().onBackPressedDispatcher.addCallback(it) {
                Toast.makeText(activity?.applicationContext, "Back pressed called", Toast.LENGTH_SHORT).show()
                var navController = activity?.let { it1 -> Navigation.findNavController(it1,R.id.my_nav_host_fragment) }
                navController?.navigateUp()
            }
        }

        // TODO: Use the ViewModel
    }

}