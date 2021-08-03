package br.com.systemsgs.controller

import br.com.systemsgs.dto.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/autores")
class CadastroAutorController {

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest){
        println(request)
    }

}