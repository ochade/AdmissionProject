package com.serverless.request

import javax.validation.constraints.NotEmpty

class CreateAdmissionRequest (

    @get:NotEmpty(message = "admission type is required")
    val admission_type: String?,
    @get:NotEmpty(message = "status is required")
    val admission_status: String?,
    @get:NotEmpty(message = "description is required")
    val admission_description: String?,
)