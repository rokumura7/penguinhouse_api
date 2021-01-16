package repositories

import com.google.inject.ImplementedBy
import models.Category
import repositories.impl.CategoryRepositoryImpl

@ImplementedBy(classOf[CategoryRepositoryImpl])
trait CategoryRepository extends Repository {
  def findAll(): Seq[Category]
  def findBy(id: Int): Category
  def save(category: Category): Int
  def update(category: Category): Int
  def delete(id: Int): Int
}
