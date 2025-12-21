package id.medihause.keycloak.totp.api.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class UnregisterTOTPCredentialRequest(
        @JsonProperty("deviceName") val deviceName: String,
) {
    companion object {
        fun validate(request: UnregisterTOTPCredentialRequest): Boolean {
            return request.deviceName.isNotEmpty()
        }
    }
}
