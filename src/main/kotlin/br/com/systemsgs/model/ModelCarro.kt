package br.com.systemsgs.model

import br.com.systemsgs.annotation.Placa
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class ModelCarro (

    @field:NotBlank(message = "Modelo deve ser Informada!")
    val modelo: String?,

    @field:NotBlank(message = "Placa deve ser Informada!")
    @field:Placa
    val placa: String?

    )
{

}