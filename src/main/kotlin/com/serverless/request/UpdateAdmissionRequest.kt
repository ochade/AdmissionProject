package com.serverless.request

import javax.validation.constraints.NotEmpty

data class UpdateAdmissionRequest (
    @get:NotEmpty(message = "admission id is required")
    val admission_id:String?,
    @get:NotEmpty(message = "client name is required")
    val admission_type:String?,
    @get:NotEmpty(message = "address is required")
    val admission_status:String?,
    @get:NotEmpty(message = "industry is required")
    val admission_description:String?,
)