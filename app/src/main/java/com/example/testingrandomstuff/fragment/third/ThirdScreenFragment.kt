package com.example.testingrandomstuff.fragment.third

import android.app.Dialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.testingrandomstuff.R
import com.example.testingrandomstuff.dialog.MyDialog
import kotlinx.android.synthetic.main.confirm_dialog.*
import kotlinx.android.synthetic.main.third_screen_fragment.*

class ThirdScreenFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdScreenFragment()
    }

    private lateinit var viewModel: ThirdScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdScreenViewModel::class.java)
        detail_text.text = arguments?.getString("detail_sting","")

        dialog_maker.setOnClickListener {
            findNavController().navigate(R.id.confirmDialog)
         //   activity?.let { it1 -> MyDialog.confirmDialog(it1) }
        }
        // TODO: Use the ViewModel
    }

    class MyDialog: DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val builder = activity?.let { AlertDialog.Builder(it) }
            val view  = activity?.layoutInflater?.inflate(R.layout.confirm_dialog, null)

            val btnConfirm = view?.findViewById(R.id.btnConfirm) as Button
            btnConfirm.setOnClickListener {
                dialog?.dismiss()
            }

            builder?.setView(view)

            return builder?.create()!!
        }

        /*override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.confirm_dialog, container, false)

            return view
        }*/
    }

}