package com.straccion.ecommerce.presentation.screens.admin.product.update

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.usecase.products.ProductsUseCase
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.presentation.screens.admin.product.update.mapper.toProduct
import com.straccion.ecommerce.presentation.util.ComposeFileProvider
import com.straccion.ecommerce.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AdminProductUpdateViewModel @Inject constructor(
    private val productUseCase: ProductsUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context,
) : ViewModel() {
    var state by mutableStateOf(AdminProductUpdateState())
        private set

    var productResponse by mutableStateOf<Response<Product>?>(null)

    var data = savedStateHandle.get<String>("product")//recupero los datos enviados

    var product = Product.fromJson(data!!)

    val resultingActivityHandler = ResultingActivityHandler()

    var file1: File? = null
    var file2: File? = null
    var files: MutableList<File> = mutableListOf()

    init {
        state = state.copy(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            idCategory = product.idCategory,
            image1 = product.image1 ?: "",
            image2 = product.image2 ?: ""
        )
    }

    fun updateProduct() = viewModelScope.launch {
        productResponse = Response.Loading
        if (file1 == null && file2 == null) {
            val result = productUseCase.updateProductUseCase(product.id!!, state.toProduct())
            productResponse = result
        } else {
            if (file1 != null) {
                files.add(file1!!)
                state.imageToUpdate.add(0)
            }
            if (file2 != null) {
                files.add(file2!!)
                state.imageToUpdate.add(1)
            }
            val result = productUseCase.updateProductWithImageUseCase(
                product.id!!,
                state.toProduct(),
                files.toList()
            )
            productResponse = result
        }
        files.clear()
        file1 = null
        file2 = null
        state.imageToUpdate.clear()
    }

    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
            } else if (imageNumber == 2) {
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
            } else if (imageNumber == 2) {
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
        state = state.copy(price = input.toIntOrNull() ?: 0)
    }
}