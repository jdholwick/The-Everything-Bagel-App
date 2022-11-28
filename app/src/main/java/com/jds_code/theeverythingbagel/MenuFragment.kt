package com.jds_code.theeverythingbagel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jds_code.theeverythingbagel.databinding.FragmentMenuBinding
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment() {

    // See comment for same in NewNoteFragment.kt
    private val sharedViewModel: TEBViewModel by activityViewModels()

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // I'm not sure if we need the following but it will be to display the options
        //  menu if that is part of this.
        //setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // This little gem is the reason my button to the next fragment was being such a
        //  massive pain... New Note Button now goes to New Note Screen!
        binding?.menuFragment = this
    }

    // This function is essentially used to "inflate" the fragment view, setting the value
    //  of '_binding', and then returning the root view.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        Log.d("MenuFragment", "MenuFragment has been created/re-created.")

        val view = binding.root
        return view
    }

    // Used in 'fragment_menu.xml' when button to make new note is clicked
    fun goToNewNoteScreen() {
        findNavController().navigate(R.id.action_menuFragment_to_newNoteFragment)
    }

    // Used in 'fragment_menu.xml' when button to see list of notes is clicked
    fun goToNoteListScreen() {
        findNavController().navigate(R.id.action_menuFragment_to_noteListFragment)
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("MenuFragment", "MenuFragment has been destroyed.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // '_binding' is set to 'null' because the view no longer exists.
        _binding = null
    }
}