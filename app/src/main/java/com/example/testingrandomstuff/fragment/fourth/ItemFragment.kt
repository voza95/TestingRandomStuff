package com.example.testingrandomstuff.fragment.fourth

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.testingrandomstuff.R
import com.example.testingrandomstuff.fragment.fourth.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                /*layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }*/
                layoutManager = LinearLayoutManager(context)

                adapter = MyItemRecyclerViewAdapter(DummyContent.ITEMS,
                object: MyItemRecyclerViewAdapter.SetOnItemClickListener{
                    override fun selectedItem(position: Int, detailString: String?) {
                        var bundle = Bundle()
                        bundle.putString("detail_sting", detailString)
                        var navController = activity?.let { Navigation.findNavController(it, R.id.my_nav_host_fragment) }
                        navController?.navigate(R.id.action_fourthFragment_to_thirdFragment, bundle)
                    }

                })
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}