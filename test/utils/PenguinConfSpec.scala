package utils

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.Helpers.status

class PenguinConfSpec extends PlaySpec with GuiceOneAppPerTest{
  "PenguinConf AWS.S3" must {
    "get accessKey" in {
      PenguinConf.AWS.S3.accessKey mustBe "penguinhouse"
    }

    "get secretKey" in {
      PenguinConf.AWS.S3.secretKey mustBe "penguinhouse"
    }

    "get endpoint" in {
      PenguinConf.AWS.S3.endpoint mustBe "http://s3:9000"
    }

    "get bucket" in {
      PenguinConf.AWS.S3.bucket mustBe "penguin"
    }
  }
}
