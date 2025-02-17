package com.straccion.ecommerce.domains.usecase.products

data class ProductsUseCase(
    val createProductsUseCase: CreateProductUseCase,
    val findAllUseCase: FindAllUseCase,
    val findProductByCategory: FindProductByCategoryUseCase,
    val updateProductUseCase: UpdateProductUseCase,
    val updateProductWithImageUseCase: UpdateProductWithImageUseCase,
    val deleteProductUseCase: DeleteProductUseCase
)
