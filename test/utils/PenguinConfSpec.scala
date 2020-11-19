package utils

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.Helpers.status

class PenguinConfSpec extends PlaySpec with GuiceOneAppPerTest{
  "PenguinConf AWS.S3" must {
    "can get accessKey" in {
      PenguinConf.AWS.S3.accessKey mustBe "penguinhouse"
    }

    "can get secretKey" in {
      PenguinConf.AWS.S3.accessKey mustBe "penguinhouse"
    }

    "can get endpoint" in {
      PenguinConf.AWS.S3.accessKey mustBe "http://s3:9000"
    }

    "can get bucket" in {
      PenguinConf.AWS.S3.accessKey mustBe "penguin"
    }
  }
}
