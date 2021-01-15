package _stub

import play.api.mvc.ControllerComponents
import play.api.test.Helpers.stubControllerComponents

abstract class AbstractControllerSpec extends AbstractSpec {
  protected val ccMock: ControllerComponents = stubControllerComponents()
}
