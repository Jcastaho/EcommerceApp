package com.straccion.ecommerce.presentation.screens.client.category.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.usecase.categories.CategoriesUseCase
import com.straccion.ecommerce.domains.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientCategoryListViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase
): ViewModel() {

    var categoriesResponse by mutableStateOf<Response<List<Category>>?>(null)
        private set

    init {
        getCategories()
    }

    fun getCategories()= viewModelScope.launch {
        categoriesResponse = Response.Loading
        categoriesUseCase.getCategoriesUseCase().collect(){
            categoriesResponse = it
        }

    }
}