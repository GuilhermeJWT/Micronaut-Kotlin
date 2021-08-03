package br.com.systemsgs.repository

import br.com.systemsgs.model.ModelAutor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository : JpaRepository<ModelAutor, Long>{

}