package _stub

import org.scalatest.{FunSpec, Matchers}
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.guice.GuiceOneAppPerTest

abstract class AbstractSpec extends FunSpec with GuiceOneAppPerTest with MockitoSugar with Matchers {

}
