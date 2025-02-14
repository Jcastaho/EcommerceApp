package com.straccion.ecommerce.presentation.screens.admin.product.create

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.usecase.categories.CategoriesUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.screens.admin.category.create.AdminCategoryCreateState
import com.straccion.ecommerce.presentation.screens.admin.category.create.mapper.toCategory
import com.straccion.ecommerce.presentation.util.ComposeFileProvider
import com.straccion.ecommerce.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminProductCreateViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(AdminProductCreateState())
        private set

    var categoryResponse by mutableStateOf<Response<Category>?>(null)

    var data = savedStateHandle.get<String>("category")//recupero los datos enviados

    var category = Category.fromJson(data!!)

    val resultingActivityHandler = ResultingActivityHandler()

    var file1: File? = null
    var file2: File? = null


    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
            }
            else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
            }
        }
    }

    fun takePhoto(context: Context, activity: Activity, imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview(context, activity)
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)
            }
            else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
            }
        }
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }

    fun onPriceInput(input: String) {
        state = state.copy(price = input.toDouble())
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image1 = "",
            image2 = "",
            price = 0.0
        )
        categoryResponse = null
    }

}