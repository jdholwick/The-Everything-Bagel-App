package com.jds_code.theeverythingbagel

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jds_code.theeverythingbagel.database.notes.Notes
import com.jds_code.theeverythingbagel.databinding.FragmentNewNoteBinding

/**
 * This fragment is used to add a new note to the Room DB.
 */
class NewNoteFragment : Fragment() {

    // The following is incomplete but will likely be used on the
    //  fragment to update a note.
    //private val navigationArgs:

    lateinit var note: Notes

    // This is an object instance of TEBViewModel that this UI controller (i.e.,
    //  NewNoteFragment.kt) will use. (Also, the 'by' keyword is simply states
    //  that the getters/setters are in 'viewModels()'.
    //private val sharedViewModel: TEBViewModel by activityViewModels()
    // The commented out code DIRECTLY ABOVE is replaced by the following for now.
    //  The sharedViewModel used above was the problem presumably.
    private val viewModel: TEBViewModel by activityViewModels {
        NotesViewModelFactory(
            (activity?.application as NotesApplication).database.notesDao()
        )
    }

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    /**
     * This function is essentially used to "inflate" the fragment view, setting the value
     * of '_binding,' and then returning the root view.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        Log.d("NewNoteFragment", "NewNoteFragment has been created/re-created.")

        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.etNoteTitle.text.toString(),
            binding.etNoteBody.text.toString(),
        )
    }

    /**
     * Inserts the note into the Room DB and navigates to menu fragment.
     */
    private fun addNewNote() {
        if (isEntryValid()) {
            viewModel.addNewNote(
                binding.etNoteTitle.text.toString(),
                binding.etNoteBody.text.toString(),
            )
        }

        // The following is all that is required to go to another fragment.
        findNavController().navigate(R.id.action_newNoteFragment_to_menuFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // May not be needed with current setup of Room DB and other aspects
/*        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            //viewModel = sharedViewModel
            // Following replaces DIRECTLY ABOVE for the moment
            viewModel = viewModel
            newNoteFragment = this@NewNoteFragment
        }*/

        binding.btnSaveNote.setOnClickListener {
            addNewNote()
        }
    }

    // This method is a redundant overriding method and shouldn't be needed anymore.
/*    override fun onCreate(savedInstanceState: Bundle?) {
        // I'm not sure if we need the following but it will be to display the options
        //  menu if that is part of this.
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }*/

    // Comparing with other code, this seems unnecessary
/*    override fun onDetach() {
        super.onDetach()
        Log.d("NewNoteFragment", "NewNoteFragment has been destroyed.")
    }*/

    override fun onDestroyView() {
        super.onDestroyView()

        // Simply hides the keyboard
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)


        // '_binding' is set to 'null' because the view no longer exists.
        _binding = null
    }
}