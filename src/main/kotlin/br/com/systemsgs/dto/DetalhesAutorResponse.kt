package br.com.systemsgs.dto

import br.com.systemsgs.model.ModelAutor

class DetalhesAutorResponse(modelAutor: ModelAutor) {

    val nome = modelAutor.nome
    val email = modelAutor.email
    val descricao = modelAutor.descricao

}