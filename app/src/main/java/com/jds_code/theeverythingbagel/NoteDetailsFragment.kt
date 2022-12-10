package com.jds_code.theeverythingbagel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jds_code.theeverythingbagel.databinding.FragmentNoteDetailsBinding

class NoteDetailsFragment : Fragment() {

    // See comment for same in NewNoteFragment.kt
    private val sharedViewModel: TEBViewModel by activityViewModels()

    private var _binding: FragmentNoteDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // See comment in 'NoteListFragment'
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)

        Log.d("NoteDetailsFragment", "NoteDetailsFragment has been created/re-created.")

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            noteDetailsFragment = this@NoteDetailsFragment
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("NoteDetailsFragment", "NoteDetailsFragment has been destroyed.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // '_binding' is set to 'null' because the view no longer exists.
        _binding = null
    }
}