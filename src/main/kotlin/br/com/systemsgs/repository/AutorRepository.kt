package br.com.systemsgs.repository

import br.com.systemsgs.model.ModelAutor
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<ModelAutor, Long>{

    fun findByEmail(email: String) : Optional<ModelAutor>

    @Query("SELECT a FROM ModelAutor a WHERE a.email = :email")
    fun buscaPorEmail(email: String) : Optional<ModelAutor>

    @Query("SELECT a FROM ModelAutor a WHERE a.nome = :nome")
    fun buscaPorNome(nome: String) : Optional<ModelAutor>

    @Query("SELECT a FROM ModelAutor a WHERE a.descricao = :descricao")
    fun buscaPorDescricao(descricao: String) : Optional<ModelAutor>

}