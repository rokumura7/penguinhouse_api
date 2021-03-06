package models

case class Category(categoryId: Option[Int], name: String, color: String)

class CategoryBuilder() {
  private var categoryId: Int = -1
  private var name: String = "unknown"
  private var color: String = "unknown"
  def categoryId(categoryId: Int): CategoryBuilder = {
    this.categoryId = categoryId
    this
  }
  def name(name: String): CategoryBuilder = {
    this.name = name
    this
  }
  def color(color: String): CategoryBuilder = {
    this.color = color
    this
  }
  def build(): Category = {
    if (name.equals("unknown") || color.equals("unknown")) {
      throw new Exception()
    }
    if (categoryId == -1) Category(categoryId = null, name = name, color = color)
    else Category(Option(categoryId), name, color)
  }
}
