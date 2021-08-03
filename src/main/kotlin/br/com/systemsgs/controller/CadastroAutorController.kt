package br.com.systemsgs.controller

import br.com.systemsgs.dto.DetalhesAutorResponse
import br.com.systemsgs.dto.ModelAutorDTO
import br.com.systemsgs.repository.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/autores")
class CadastroAutorController (val autorRepository: AutorRepository){

    @Post("/salvar")
    fun cadastra(@Body @Valid modelAutorDTO: ModelAutorDTO) : HttpResponse<Any>{
        val modelAutor = modelAutorDTO.converteEntidade()
        autorRepository.save(modelAutor)

        val uri = UriBuilder.of("/api/autores/salvar/{id}").expand(mutableMapOf(Pair("id", modelAutor.id)))

        return HttpResponse.created(uri)
    }

    @Get("/listarTodos")
    fun listar() : HttpResponse<List<DetalhesAutorResponse>>{
        val autores = autorRepository.findAll()
        val resposta = autores.map { autor -> DetalhesAutorResponse(autor) }

        return HttpResponse.ok(resposta)
    }

}