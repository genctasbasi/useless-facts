package com.escmobile.uselessfacts.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escmobile.uselessfacts.data.Fact
import com.escmobile.uselessfacts.data.FactRepo
import com.escmobile.uselessfacts.util.Util.Companion.DEFAULT_LANG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UselessFactViewModel(private val repo: FactRepo) : ViewModel() {

    private val _factObservable = MutableLiveData<Fact>()
    val factObservable: LiveData<Fact> = _factObservable

    fun onGetFactButtonClick()  {
        getFact()
    }

    private fun getFact(_lang: String? = null) {

        val lang = if (_lang == "de") "de" else DEFAULT_LANG

        viewModelScope.launch(Dispatchers.IO) {

            val response = repo.getFact(lang)

            withContext(Dispatchers.Main) {
                // TODO: Handle error
                response.fact?.let {
                    _factObservable.value = it
                }
            }
        }
    }
}