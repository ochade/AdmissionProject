package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.AdmissionModel
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.DeleteAdmissionRequest
import com.serverless.request.UpdateAdmissionRequest
import com.serverless.response.BaseResponse
import com.serverless.response.ListResponse
import com.serverless.service.AdmissionService


class AdmissionController() {
    private val admissionService: AdmissionService = AdmissionService()

    fun createAdmissionTable(request:String) {
        admissionService.createAdmissionTable()
    }

    fun createAdmission(request: String): Any{
        val createAdmissionRequest = Gson().fromJson(request, CreateAdmissionRequest::class.java)
        val admission = AdmissionModel(admission_id = 0, createAdmissionRequest.admission_type, createAdmissionRequest.admission_status, createAdmissionRequest.admission_description)
        return BaseResponse("00", "note created successfully")
       // admissionService.createAdmission(admissionModel)
    }

    fun selectAllAdmission(): Any{
        val admission = admissionService.selectAllAdmission()
        return ListResponse("00","successful",admission)

    }
    fun deleteAdmission(request: String): Any{
        //val deleteAdmissionRequest = Gson().fromJson(request, DeleteAdmissionRequest::class.java)
        val deleteAdmissionRequest = Gson().fromJson(request, DeleteAdmissionRequest::class.java)
       // clientService.deleteClientsTable(client_id = deleteAdmissionRequest.client_id!!.toInt())


        return BaseResponse("00","client deleted sucesfully")
    }
    fun updateAdmission(request: String):Any{
        val updateAdmissionRequest= Gson().fromJson(request, UpdateAdmissionRequest:: class.java)
        val admission = Admission(updateAdmissionRequest.admission_id.toString(),updateAdmissionRequest.admission_type,updateAdmissionRequest.admission_status,updateAdmissionRequest.admission_description)
        admissionService.updateAdmission(admission)

        return BaseResponse("00","client updated sucesfully")
    }
}

