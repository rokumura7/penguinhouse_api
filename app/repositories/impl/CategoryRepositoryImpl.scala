package repositories.impl

import models.{Category, CategoryBuilder}
import play.api.db.Database
import repositories.{AbstractRepository, CategoryRepository}

import javax.inject.{Inject, Singleton}

@Singleton
class CategoryRepositoryImpl @Inject()(db: Database)  extends AbstractRepository(db) with CategoryRepository {
  override def findAll(): List[Category] = {
    execute(s"SELECT * FROM categories;") { rs =>
      val list = List[Category]()
      while (rs.next()) {
        val builder = new CategoryBuilder()
        builder
          .name(rs.getString("name"))
          .color(rs.getString("color"))
        list :+ builder.build()
      }
      list
    }
  }
  override def findBy(id: Int): Category = {
    execute(s"SELECT * FROM categories WHERE category_id = ${id};") { rs =>
      val builder = new CategoryBuilder()
      while (rs.next()) {
        builder.categoryId(id)
          .name(rs.getString("name"))
          .color(rs.getString("color"))
      }
      builder.build()
    }
  }

  override def save(category: Category): Int = {
    executeUpdate(
      s"INSERT INTO categories (name, color) " +
        s"VALUES (${category.name}, ${category.color};") { rs => rs }
  }

  override def update(category: Category): Int = {
    executeUpdate(
      s"UPDATE categories " +
        s"SET name = ${category.name}, color = ${category.color} " +
        s"WHERE category_id = ${category.categoryId}") { rs => rs }
  }

  override def delete(id: Int): Int = {
    executeUpdate(s"DELETE FROM categories WHERE category_id = ${id}") { rs => rs }
  }
}
