package repositories.impl

import models.{Category, CategoryBuilder}
import play.api.db.Database
import repositories.{AbstractRepository, CategoryRepository}

import javax.inject.{Inject, Singleton}

@Singleton
class CategoryRepositoryImpl @Inject()(db: Database)  extends AbstractRepository(db) with CategoryRepository {
  override def findBy(id: Int): Category = {
    val result = execute(s"SELECT * FROM categories WHERE category_id = ${id};") { rs =>
      val builder = new CategoryBuilder()
      while (rs.next()) {
        builder.categoryId(id)
          .name(rs.getString("name"))
          .color(rs.getString("color"))
      };
      builder.build()
    }
    result
  }
}
