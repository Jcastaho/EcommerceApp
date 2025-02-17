package com.straccion.ecommerce.di


import com.straccion.ecommerce.domains.repository.AuthRepository
import com.straccion.ecommerce.domains.repository.CategoryRepository
import com.straccion.ecommerce.domains.repository.ProductsRepository
import com.straccion.ecommerce.domains.repository.ShoppingBagRepository
import com.straccion.ecommerce.domains.repository.UsersRepository
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.usecase.auth.GetSessionDataUseCase
import com.straccion.ecommerce.domains.usecase.auth.LoginUseCase
import com.straccion.ecommerce.domains.usecase.auth.LogoutUseCase
import com.straccion.ecommerce.domains.usecase.auth.RegisterUseCase
import com.straccion.ecommerce.domains.usecase.auth.SaveSessionUseCase
import com.straccion.ecommerce.domains.usecase.auth.UpdateSessionUseCase
import com.straccion.ecommerce.domains.usecase.categories.CategoriesUseCase
import com.straccion.ecommerce.domains.usecase.categories.CreateCategoryUseCase
import com.straccion.ecommerce.domains.usecase.categories.DeleteCategoryUseCase
import com.straccion.ecommerce.domains.usecase.categories.GetCategoriesUseCase
import com.straccion.ecommerce.domains.usecase.categories.UpdateCategoryUseCase
import com.straccion.ecommerce.domains.usecase.categories.UpdateWithImageCategoryUseCase
import com.straccion.ecommerce.domains.usecase.products.CreateProductUseCase
import com.straccion.ecommerce.domains.usecase.products.DeleteProductUseCase
import com.straccion.ecommerce.domains.usecase.products.FindAllUseCase
import com.straccion.ecommerce.domains.usecase.products.FindProductByCategoryUseCase
import com.straccion.ecommerce.domains.usecase.products.ProductsUseCase
import com.straccion.ecommerce.domains.usecase.products.UpdateProductUseCase
import com.straccion.ecommerce.domains.usecase.products.UpdateProductWithImageUseCase
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagAddUseCase
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagDeleteUseCase
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagFindAllUseCase
import com.straccion.ecommerce.domains.usecase.shoppingbag.ShoppingBagUseCase
import com.straccion.ecommerce.domains.usecase.users.UpdateUserUseCase
import com.straccion.ecommerce.domains.usecase.users.UpdateUserWithImageUseCase
import com.straccion.ecommerce.domains.usecase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) =
        AuthUseCase(
            login = LoginUseCase(authRepository),
            register = RegisterUseCase(authRepository),
            saveSessionUseCase = SaveSessionUseCase(authRepository),
            getSessionDataUseCase = GetSessionDataUseCase(authRepository),
            logoutUseCase = LogoutUseCase(authRepository),
            updateSessionUseCase = UpdateSessionUseCase(authRepository)
        )

    @Provides
    fun provideUserUseCase(usersRepository: UsersRepository) =
        UsersUseCase(
            updateUserUseCase = UpdateUserUseCase(usersRepository),
            updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
        )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoryRepository) =
        CategoriesUseCase(
            createCategoryUseCase = CreateCategoryUseCase(categoriesRepository),
            getCategoriesUseCase = GetCategoriesUseCase(categoriesRepository),
            updateCategoryUseCase = UpdateCategoryUseCase(categoriesRepository),
            updateWithImageCategoryUseCase = UpdateWithImageCategoryUseCase(categoriesRepository),
            deleteCategoryUseCase = DeleteCategoryUseCase(categoriesRepository)
        )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) =
        ProductsUseCase(
            createProductsUseCase = CreateProductUseCase(productsRepository),
            findProductByCategory = FindProductByCategoryUseCase(productsRepository),
            findAllUseCase = FindAllUseCase(productsRepository),
            updateProductUseCase = UpdateProductUseCase(productsRepository),
            updateProductWithImageUseCase = UpdateProductWithImageUseCase(productsRepository),
            deleteProductUseCase = DeleteProductUseCase(productsRepository),
        )

    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) =
        ShoppingBagUseCase(
            addUseCase = ShoppingBagAddUseCase(shoppingBagRepository),
            deleteUseCase = ShoppingBagDeleteUseCase(shoppingBagRepository),
            findAllUseCase = ShoppingBagFindAllUseCase(shoppingBagRepository)
        )

}