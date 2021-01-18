package repositories

import java.sql.ResultSet
import play.api.db.Database
import utils.Closable

abstract class AbstractRepository(protected val db: Database) extends Repository with Closable{
  def execute[A](sql: String)( func: ResultSet => A ): A = using(db.getConnection()) { con =>
    func(con.createStatement.executeQuery(sql))
  }
  def executeUpdate(sql: String)( func: Int => Int ): Int = using(db.getConnection()) { con =>
    func(con.createStatement.executeUpdate(sql))
  }
}
