package com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp

import com.straccion.ecommerce.data.datasource.remote.repository.datasource.ProductsRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.service.ProductsService
import com.straccion.ecommerce.domains.model.Product
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class ProductsRemoteDataSourceImpl(
    private val productsService: ProductsService
) : ProductsRemoteDataSource {

    override suspend fun findAll(): Response<List<Product>> = productsService.findAll()

    override suspend fun findByCategory(idCategory: String): Response<List<Product>> =
        productsService.findByCategory(idCategory)

    override suspend fun create(product: Product, files: List<File>): Response<Product> {
        val image = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"
        files.forEachIndexed { index, file ->
            val conection = file.toURI().toURL().openConnection()
            val mimeType = conection.contentType
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            image[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
        }
        val nameData = product.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = product.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategoryData =
            product.idCategory.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val priceData = product.price.toString().toRequestBody(contentType.toMediaTypeOrNull())
        return productsService.create(image, nameData, descriptionData, idCategoryData, priceData)
    }

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File?>
    ): Response<Product> {
        val image = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"
        val imageToUpdate = arrayOfNulls<RequestBody>(product.imageToUpdate?.size ?: 0)
        files.forEachIndexed { index, file ->
            val conection = file?.toURI()?.toURL()?.openConnection()
            val mimeType = conection?.contentType
            val requestFile = file?.asRequestBody(mimeType?.toMediaTypeOrNull())
            image[index] = MultipartBody.Part.createFormData("files[]", file?.name, requestFile!!)
        }

        product.imageToUpdate?.forEachIndexed { index, position ->
            imageToUpdate[index] = position.toString().toRequestBody(contentType.toMediaTypeOrNull())
        }
        val nameData = product.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = product.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategoryData =
            product.idCategory.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val priceData = product.price.toString().toRequestBody(contentType.toMediaTypeOrNull())
        return productsService.updateWithImage(
            image,
            id,
            nameData,
            descriptionData,
            idCategoryData,
            priceData,
            imageToUpdate
        )
    }

    override suspend fun update(id: String, product: Product): Response<Product> =
        productsService.update(id, product)

    override suspend fun delete(id: String): Response<Unit> = productsService.delete(id)

}