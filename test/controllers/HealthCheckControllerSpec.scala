package controllers

import org.mockito.Mockito._
import play.api.test._
import play.api.test.Helpers._
import repositories.HealthCheckRepository
import _stub.AbstractControllerSpec

class HealthCheckControllerSpec extends AbstractControllerSpec {
  private val repoMock = mock[HealthCheckRepository]
  private val controller = new HealthCheckController(ccMock, repoMock)

  describe("HealthCheckController") {
    it("can get OK from web()") {
      val result = controller.web().apply(FakeRequest())
      status(result) shouldBe OK
    }

    it("can get OK from db()") {
      when(repoMock.canConnect).thenReturn(true)
      val result = controller.db().apply(FakeRequest())
      status(result) shouldBe OK
    }

    it("must fail when loosing connection to db") {
      when(repoMock.canConnect).thenReturn(false)
      val result = controller.db().apply(FakeRequest())
      status(result) shouldBe INTERNAL_SERVER_ERROR
    }
  }
}
