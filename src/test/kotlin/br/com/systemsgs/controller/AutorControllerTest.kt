package br.com.systemsgs.controller

import br.com.systemsgs.dto.ModelAutorDTO
import br.com.systemsgs.model.ModelAutor
import br.com.systemsgs.repository.AutorRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class AutorControllerTest{

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/api")
    lateinit var client: HttpClient

    lateinit var modelAutor: ModelAutor

    @BeforeEach
    internal fun setup(){
        val modelAutor = ModelAutor("Guilherme", "guilherme@gmail.com", "Dev Java")

        autorRepository.save(modelAutor)
    }

    /*Deletar somente no banco em Memória - H2*/
    @AfterEach
    internal fun tearDown(){
        //autorRepository.deleteAll()
    }

    @Test
    internal fun `deve retornar os detalhes de um autor` (){
        val response = client.toBlocking().exchange("/autores?email=${modelAutor.email}", ModelAutorDTO::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        assertEquals(modelAutor.nome, response.body()!!.nome)
        assertEquals(modelAutor.email, response.body()!!.email)
        assertEquals(modelAutor.descricao, response.body()!!.descricao)
    }

}