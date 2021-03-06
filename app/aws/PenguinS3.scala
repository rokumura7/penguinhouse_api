package aws

import java.io.File
import java.net.URI
import software.amazon.awssdk.auth.credentials.{AwsBasicCredentials, StaticCredentialsProvider}
import software.amazon.awssdk.core.ResponseInputStream
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.model.{DeleteObjectRequest, DeleteObjectResponse, GetObjectRequest, GetObjectResponse, PutObjectRequest, PutObjectResponse}
import software.amazon.awssdk.services.s3.{S3Client, S3Configuration}
import utils.PenguinConf

object PenguinS3 {
  def get(objKey: String): ResponseInputStream[GetObjectResponse] =
    client.getObject(RequestBuilder.getReq(objKey))

  def put(file: File, objKey: String): PutObjectResponse =
    client.putObject(RequestBuilder.putReq(objKey), file.toPath)

  def delete(objKey: String): DeleteObjectResponse =
    client.deleteObject(RequestBuilder.delReq(objKey))

  private def client: S3Client = {
    val credential = AwsBasicCredentials.create(
      PenguinConf.AWS.S3.accessKey,
      PenguinConf.AWS.S3.secretKey
    )
    val config = S3Configuration.builder()
      .pathStyleAccessEnabled(true)
      .build()
    S3Client.builder()
      .region(Region.AP_NORTHEAST_1)
      .credentialsProvider(StaticCredentialsProvider.create(credential))
      .endpointOverride(URI.create(PenguinConf.AWS.S3.endpoint))
      .serviceConfiguration(config)
      .build()
  }

  private object RequestBuilder {
    def getReq(objKey: String): GetObjectRequest =
      GetObjectRequest.builder()
        .bucket(PenguinConf.AWS.S3.bucket)
        .key(objKey)
        .build()

    def putReq(objKey: String): PutObjectRequest =
      PutObjectRequest.builder()
        .bucket(PenguinConf.AWS.S3.bucket)
        .key(objKey)
        .build()

    def delReq(objKey: String): DeleteObjectRequest =
      DeleteObjectRequest.builder()
        .bucket(PenguinConf.AWS.S3.bucket)
        .key(objKey)
        .build()
  }
}
