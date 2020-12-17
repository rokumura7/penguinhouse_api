package repositories

import com.google.inject.ImplementedBy
import repositories.impl.HealthCheckRepositoryImpl

@ImplementedBy(classOf[HealthCheckRepositoryImpl])
trait HealthCheckRepository extends Repository {
  def canConnect: Boolean
}
