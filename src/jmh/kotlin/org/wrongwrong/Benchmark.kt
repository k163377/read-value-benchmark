package org.wrongwrong

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import com.fasterxml.jackson.module.kotlin.readValue

@State(Scope.Benchmark)
open class Benchmark {
    companion object {
        val mapper = jacksonObjectMapper()
        val typeRef = jacksonTypeRef<Map<String, Any>>()
        const val input = "{}"
    }

    @Benchmark
    fun readByExtension() = mapper.readValue<Map<String, Any>>(input)

    @Benchmark
    fun readByTypeRef() = mapper.readValue(input, typeRef)
}
