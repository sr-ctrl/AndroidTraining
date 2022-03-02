package com.example.androidtraining.collapseToolBar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentLocationBinding
import com.example.androidtraining.bottomsheetdialog.TestBottomSheetDialogFragment
import com.example.androidtraining.mvvmRetrofit.Post
import com.example.androidtraining.mvvmRetrofit.PostViewModel
import com.example.androidtraining.mvvmShopping.Shop
import com.example.androidtraining.mvvmShopping.ShoppingViewModel
import org.koin.android.ext.android.inject

class LocationFragment : BaseFragment() {

    companion object{
        fun newInstance(): LocationFragment {
            val args = Bundle()
            val fragment = LocationFragment()
            fragment.arguments = args
            return fragment
        }
    }
    private var shopList: List<Post>? = null
//    private val viewModel:ShoppingViewModel by inject()
    private val viewModel:PostViewModel by inject()
    lateinit var binding: FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location,null,false)
//        Log.i("Debug", "onCreateView: FragmentA")


        return binding.root
    }
    override fun init() {


    }

    override fun observe() {
//        Log.i("Debug", "loaded ")
        viewModel.getPostList()
        Log.i("Debug", "Location Fragment ShoppingList Size:${viewModel.postList.value?.size} ")
        viewModel.postList.observe(requireActivity(),{
            Log.i("Debug", "Location Fragment  observing the list-- $it ")

            shopList = it

//            adapter.items = it as ArrayList<Shop>
//            adapter.notifyDataSetChanged()
//            Log.i("Debug", "observe:$it ")
//            it.map {
////                Log.i("Debug", "id:${it.id} ")
//            }
        })
    }

    override fun setListner() {
//       binding.btnAdd.setOnClickListener {
//           parentFragmentManager.beginTransaction()
//               .replace(R.id.add_fragment,GroupFragment.newInstance(),"")
//               .addToBackStack("")
//               .commit()
//           Log.i("Debug", "setListner: add backstack Frag A ")
//       }
        binding.selectedText.setOnClickListener {
            Log.i("Debug", "listner Location Fragment onclick shoppingList pass ")
            TestBottomSheetDialogFragment.newInstance(shopList).show(childFragmentManager,null)
//            val string = "Test Sample"
//            val bundle = Bundle()
//            bundle.putString("test",string)
//            val fragment = TestBottomSheetDialogFragment()
//            fragment.arguments = bundle
//            Log.d("Debug", "setListner: fragment args ${fragment.arguments.toString()}")
//            fragment.show(childFragmentManager,"")
        }
    }

    override fun Load() {

    }


//    override fun onResume() {
//        super.onResume()
//        Log.i("Debug", "onResume: FragmentA")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i("Debug", "onStop: FragmentA")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i("Debug", "onDestroy: FragmentA")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.i("Debug", "onDestroyView:FragmentA ")
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.i("Debug", "onAttach:FragmentA ")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.i("Debug", "onDetach: FragmentA ")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i("Debug", "onPause:FragmentA ")
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.i("Debug", "onCreate: FragmentA")
//    }



}