package com.jds_code.theeverythingbagel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.jds_code.theeverythingbagel.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {

    // See comment for same in NewNoteFragment.kt
    private val sharedViewModel: TEBViewModel by activityViewModels()

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // I'm not sure if we need the following but it will be to display the options
        //  menu if that is part of this.
        //setHasOptionsMenu(true)
    }

    // This function is essentially used to "inflate" the fragment view, setting the value
    //  of '_binding', and then returning the root view.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)

        Log.d("NoteListFragment", "NoteListFragment has been created/re-created.")

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            noteListFragment = this@NoteListFragment
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("NoteListFragment", "NoteListFragment has been destroyed.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // '_binding' is set to 'null' because the view no longer exists.
        _binding = null
    }

    private fun chooseLayout() {
        // Probably we won't need this as the layout isn't going to change in
        //  its basic elements, I don't think.
    }
}