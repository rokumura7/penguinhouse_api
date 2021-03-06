package repositories.impl

import javax.inject.{Inject, Singleton}
import play.api.db.Database
import repositories.{AbstractRepository, HealthCheckRepository}

@Singleton
class HealthCheckRepositoryImpl @Inject()(db: Database) extends AbstractRepository(db) with HealthCheckRepository {
  def canConnect: Boolean = {
    val result = execute("SELECT 200 AS res;") { rs =>
      var res = ""
      while (rs.next()) res += rs.getString("res");
      res
    }
    !result.isEmpty
  }
}
