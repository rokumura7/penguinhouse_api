package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

class HealthCheckControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "HealthCheckController GET" must {
    "Able to access '/api/v1/h' with GET" in {
      val request  = FakeRequest(GET, "/api/v1/h")
      val response = route(app, request).get
      status(response) mustBe OK
    }
  }
}
