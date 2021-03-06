package utils

import com.typesafe.config.ConfigFactory

object PenguinConf {
  private def get(key: String): String = ConfigFactory.load.getString(key)
  object AWS {
    object S3 {
      def accessKey: String = get("aws.s3.accessKey")
      def secretKey: String = get("aws.s3.secretKey")
      def endpoint: String  = get("aws.s3.endpoint")
      def bucket: String    = get("aws.s3.bucket")
    }
  }
}
