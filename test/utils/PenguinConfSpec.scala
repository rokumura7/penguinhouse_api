package utils

import _stub.AbstractSpec

class PenguinConfSpec extends AbstractSpec {
  describe("PenguinConf AWS.S3") {
    it("can get accessKey") {
      PenguinConf.AWS.S3.accessKey shouldBe "penguinhouse"
    }

    it("can get secretKey") {
      PenguinConf.AWS.S3.secretKey shouldBe "penguinhouse"
    }

    it("can get endpoint") {
      PenguinConf.AWS.S3.endpoint shouldBe "http://s3:9000"
    }

    it("can get bucket") {
      PenguinConf.AWS.S3.bucket shouldBe "penguin"
    }
  }
}
