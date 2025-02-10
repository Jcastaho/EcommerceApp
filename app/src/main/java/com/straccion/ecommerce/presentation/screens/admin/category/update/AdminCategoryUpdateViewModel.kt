package com.straccion.ecommerce.presentation.screens.admin.category.update

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
import com.straccion.ecommerce.presentation.screens.admin.category.create.mapper.toCategory
import com.straccion.ecommerce.presentation.screens.admin.category.update.mapper.toCategory
import com.straccion.ecommerce.presentation.util.ComposeFileProvider
import com.straccion.ecommerce.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryUpdateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
) :
    ViewModel() {
    var state by mutableStateOf(AdminCategoryUpdateState())
        private set

    var categoryResponse by mutableStateOf<Response<Category>?>(null)

    val resultingActivityHandler = ResultingActivityHandler()
    var file: File? = null

    val data = savedStateHandle.get<String>("category")
    val category = Category.fromJson(data!!)

    init {
        state = state.copy(
            name = category.name,
            image = category.image!!,
            description = category.description
        )
    }

    fun onUpdate(){
        if (file!= null){
            updateCategoryWithImage()
        }else{
            updateCategory()
        }
    }

    fun updateCategory() = viewModelScope.launch {
        categoryResponse = Response.Loading
        val result = categoriesUseCase.updateCategoryUseCase(id = category.id!!, state.toCategory())
        categoryResponse = result
    }

    fun updateCategoryWithImage() = viewModelScope.launch {
        categoryResponse = Response.Loading
        val result = categoriesUseCase.updateWithImageCategoryUseCase(
            id = category.id!!,
            state.toCategory(),
            file!!
        )
        categoryResponse = result
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
}