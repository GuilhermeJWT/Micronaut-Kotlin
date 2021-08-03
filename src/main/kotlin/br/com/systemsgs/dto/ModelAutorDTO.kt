package br.com.systemsgs.dto

import br.com.systemsgs.model.ModelAutor
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class ModelAutorDTO (
    
    @field:NotBlank(message = "O Nome deve ser Informado!")
    val nome: String,

    @field:NotBlank(message = "E-Mail deve ser Informado!")
    @field:Email(message = "Formato de E-Mail Inválido!")
    val email: String,

    @field:NotBlank(message = "A Descrição deve ser Informada!")
    @field:Size(max = 400, message = "Descrição deve ter no Máximo 400 Caracteres")
    val descricao: String



)
{
    fun converteEntidade(): ModelAutor {
      return ModelAutor(nome, email, descricao)
    }
}