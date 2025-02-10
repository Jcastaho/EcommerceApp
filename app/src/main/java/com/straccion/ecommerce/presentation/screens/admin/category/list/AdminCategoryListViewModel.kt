package com.straccion.ecommerce.presentation.screens.admin.category.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.usecase.categories.CategoriesUseCase
import com.straccion.ecommerce.domains.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCategoryListViewModel @Inject constructor(private val categoriesUseCase: CategoriesUseCase) :
    ViewModel() {

    var categoriesResponse by mutableStateOf<Response<List<Category>>?>(null)
        private set

    init {
        getCategories()
    }

    fun getCategories() = viewModelScope.launch {
        categoriesResponse = Response.Loading
        categoriesUseCase.getCategoriesUseCase().collect() { data ->
            categoriesResponse = data

        }

    }
}