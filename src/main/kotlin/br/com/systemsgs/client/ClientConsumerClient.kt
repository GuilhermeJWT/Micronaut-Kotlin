package br.com.systemsgs.client

import br.com.systemsgs.dto.ModelClientesDTO
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("localhost:8888/api/v1/clientes")
interface ClientConsumerClient {

    @Get("/listaTodos")
    fun listaClientes() : List<ModelClientesDTO>

}