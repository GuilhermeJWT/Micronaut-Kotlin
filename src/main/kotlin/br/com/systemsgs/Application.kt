package br.com.systemsgs

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {

	build().args(*args).packages("br.com.systemsgs").start()

	System.out.println("Debugando");

}

