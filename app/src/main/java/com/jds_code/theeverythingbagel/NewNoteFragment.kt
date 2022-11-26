package com.jds_code.theeverythingbagel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.jds_code.theeverythingbagel.databinding.FragmentNewNoteBinding

class NewNoteFragment : Fragment() {

    // This is an object instance of TEBViewModel that this UI controller (i.e.,
    //  NewNoteFragment.kt) will use. (Also, the 'by' keyword is simply states
    //  that the getters/setters are in 'viewModels()'.
    private val sharedViewModel: TEBViewModel by activityViewModels()

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        // I'm not sure if we need the following but it will be to display the options
        //  menu if that is part of this.
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    // This function is essentially used to "inflate" the fragment view, setting the value
    //  of '_binding', and then returning the root view.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        Log.d("NewNoteFragment", "NewNoteFragment has been created/re-created.")

        val view = binding.root
        return view
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("NewNoteFragment", "NewNoteFragment has been destroyed.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // '_binding' is set to 'null' because the view no longer exists.
        _binding = null
    }
}