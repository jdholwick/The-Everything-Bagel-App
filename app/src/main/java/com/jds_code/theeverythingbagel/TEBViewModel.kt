package com.jds_code.theeverythingbagel

import androidx.lifecycle.ViewModel

class TEBViewModel : ViewModel() {

    // These had been in NewNoteFragment.kt but should now be here in TEBViewModel.
    //  Also, we need these to have backing backing properties like this so the
    //  _variable is editable and accessible only in TEBViewModel.
    private var _noteTitle = "title"
    val noteTitle: String
        get() = _noteTitle

    private var _noteBody = "words words words"
    val noteBody: String
        get() = _noteBody


}