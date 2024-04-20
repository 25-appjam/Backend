package com.anys34.appjam.infra.s3.service

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.anys34.appjam.global.config.properties.S3Properties
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.UUID

@Service
class S3Service(
        private val s3Properties: S3Properties,
        private val amazonS3Client: AmazonS3Client
) {
    fun uploadFile(file: MultipartFile):String {
        val filePath = "appjam/" + UUID.randomUUID()
        try {
            val request = PutObjectRequest(
                    s3Properties.getBucket(),
                    filePath,
                    file.inputStream,
                    getObjectMetadata(file)
            )
            amazonS3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead))
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return amazonS3Client.getUrl(s3Properties.getBucket(), filePath).toString()
    }

    private fun getObjectMetadata(file: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = file.size
        objectMetadata.contentType = file.contentType
        return objectMetadata
    }
}