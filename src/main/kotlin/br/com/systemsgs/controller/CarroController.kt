package br.com.systemsgs.controller

import br.com.systemsgs.model.ModelCarro
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller
@Validated
class CarroController {

    @Post("/api/carros")
    fun criar(@Body @Valid modelCarro: ModelCarro) : HttpResponse<Any>{
        return HttpResponse.ok(modelCarro)
    }

}