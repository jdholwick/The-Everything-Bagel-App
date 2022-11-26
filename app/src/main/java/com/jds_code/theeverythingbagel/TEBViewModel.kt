package com.jds_code.theeverythingbagel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TEBViewModel : ViewModel() {

    // These had been in NewNoteFragment.kt but should now be here in TEBViewModel.
    //  Also, we need these to have backing backing properties like this so the
    //  _variable is editable and accessible only in TEBViewModel.
    private var _noteTitle = MutableLiveData<String>("")
    val noteTitle: LiveData<String> = _noteTitle

    private var _noteBody = MutableLiveData<String>("")
    val noteBody: LiveData<String> = _noteBody

    init {
        Log.d("TEBViewModel", "TEBViewModel has been created.")
    }

    // I'm not 100% certain, but I think this is the best way to save the note
    //  title and body the user inputs.
    fun setNoteTitle(newNoteTitle: String) {
        _noteTitle.value = newNoteTitle
    }

    fun setNoteBody(newNoteBody: String) {
        _noteBody.value = newNoteBody
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TEBViewModel", "TEBViewModel has been destroyed.")
    }
}