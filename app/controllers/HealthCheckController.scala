package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import play.api.db.Database

@Singleton
class HealthCheckController @Inject()(cc: ControllerComponents, db: Database) extends AbstractController(cc) {
  def h(): Action[AnyContent] = Action(Ok)
  def db(): Action[AnyContent] = Action {
    var result = ""
    val con = db.getConnection()
    try {
      val rs = con.createStatement.executeQuery("SELECT 200 AS res;")
      while (rs.next()) {
        result += rs.getString("res")
      }
    } finally {
      con.close()
    }
    Ok(result)
  }
}

