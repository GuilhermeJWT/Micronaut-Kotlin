package br.com.systemsgs.controller

import br.com.systemsgs.client.ClientConsumerClient
import br.com.systemsgs.dto.ModelClientesDTO
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class ClienteController(val clientConsumerClient: ClientConsumerClient) {

    @Get("/api/kotlin/consumer/clientes")
    fun listaTodosClientes() : List<ModelClientesDTO>{
        return clientConsumerClient.listaClientes()
    }

}