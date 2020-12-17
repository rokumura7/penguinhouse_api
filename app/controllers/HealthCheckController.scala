package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import repositories.HealthCheckRepository

@Singleton
class HealthCheckController @Inject()(
                                       cc: ControllerComponents,
                                       repo: HealthCheckRepository
                                     ) extends AbstractController(cc) {
  def web(): Action[AnyContent] = Action(Ok)

  def db(): Action[AnyContent] = Action {
    if (repo.canConnect) Ok("Connected.") else InternalServerError("Fail to Connect.")
  }
}

