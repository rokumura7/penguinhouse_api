package controllers

import models.Category
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import repositories.CategoryRepository

import javax.inject.{Inject, Singleton}

@Singleton
class CategoryController @Inject()(
                                  cc: ControllerComponents,
                                  repo: CategoryRepository
                                  ) extends AbstractController(cc) {
  implicit val categoryJson: OFormat[Category] = Json.format[Category]

  def get(id: Int): Action[AnyContent] = Action {
    val data = repo.findBy(id)
    Ok(Json.toJson(data))
  }
}
