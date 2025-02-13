package com.straccion.ecommerce.data.datasource.local.repository.datasourceimp

import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity
import com.straccion.ecommerce.data.datasource.local.repository.datasource.CategoriesLocalDataSource
import kotlinx.coroutines.flow.Flow

class CategoriesLocalDataSourceImpl(
    private val cateriesDao: CategoriesDao
) : CategoriesLocalDataSource {
    override suspend fun create(category: CategoryEntity) = cateriesDao.insert(category)

    override suspend fun insertAll(categories: List<CategoryEntity>) = cateriesDao.insertAll(categories)

    override fun getCategories(): Flow<List<CategoryEntity>> = cateriesDao.getCategories()

    override suspend fun update(id: String, name: String, description: String, image: String) =
        cateriesDao.update(id, name, description, image)

    override suspend fun delete(id: String) = cateriesDao.delete(id)
}