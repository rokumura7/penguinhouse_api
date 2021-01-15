package repositories

import com.google.inject.ImplementedBy
import models.Category
import repositories.impl.CategoryRepositoryImpl

@ImplementedBy(classOf[CategoryRepositoryImpl])
trait CategoryRepository extends Repository {
  def findBy(id: Int): Category
}
