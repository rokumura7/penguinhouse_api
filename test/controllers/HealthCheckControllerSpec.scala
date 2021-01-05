package controllers

import org.mockito.Mockito._
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.mvc.ControllerComponents
import play.api.mvc.Results.InternalServerError
import play.api.test._
import play.api.test.Helpers._
import repositories.HealthCheckRepository

object HealthCheckControllerSpec extends PlaySpec with GuiceOneAppPerTest with MockitoSugar {
  private val ccMock = mock[ControllerComponents]
  private val repoMock = mock[HealthCheckRepository]
  private val controller = new HealthCheckController(ccMock, repoMock)

  private val failRepoMock = mock[HealthCheckRepository]
  when(failRepoMock.canConnect).thenReturn(false)
  private val failController = new HealthCheckController(ccMock, failRepoMock)

  "HealthCheckController" must {
    "web be valid" in {
      val result = controller.web().apply(FakeRequest())
      status(result) mustBe OK
    }

    "db be valid" in {
      val result = controller.db().apply(FakeRequest())
      status(result) mustBe OK
    }

    "db be invalid" in {
      val result = failController.db().apply(FakeRequest())
      status(result) mustBe InternalServerError
    }
  }
}
