package com.straccion.ecommerce.presentation.screens.admin.category.create

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.usecase.categories.CategoriesUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.screens.admin.category.create.mapper.toCategory
import com.straccion.ecommerce.presentation.util.ComposeFileProvider
import com.straccion.ecommerce.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    @ApplicationContext private val context: Context
) :
    ViewModel() {
    var state by mutableStateOf(AdminCategoryCreateState())
        private set

    var categoryResponse by mutableStateOf<Response<Category>?>(null)

    val resultingActivityHandler = ResultingActivityHandler()
    var file: File? = null

    fun createCategory() = viewModelScope.launch {
        if (file != null){
            categoryResponse = Response.Loading
            val result = categoriesUseCase.createCategoryUseCase(state.toCategory(), file!!)
            categoryResponse = result
        }
    }


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto(context: Context, activity: Activity) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview(context, activity)
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
        }
        file = File(state.image)
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }
    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }

    fun clearForm(){
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse = null
    }

}