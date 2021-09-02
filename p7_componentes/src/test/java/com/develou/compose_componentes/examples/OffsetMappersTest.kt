package com.develou.compose_componentes.examples

import com.develou.compose_componentes.examples.TextField.PrefixOffsetMapping
import com.develou.compose_componentes.examples.TextField.SuffixOffsetMapping
import org.junit.Assert.*
import org.junit.Test

class OffsetMappersTest{

    @Test
    fun `prefijo de un caracter`(){
        val mapper = PrefixOffsetMapping("$")
        assertEquals(0, mapper.transformedToOriginal(0))
        assertEquals(0, mapper.transformedToOriginal(1))
        assertEquals(1, mapper.transformedToOriginal(2))
    }

    @Test
    fun `prefijo dos caracteres`(){
        val mapper = PrefixOffsetMapping("Pr")
        assertEquals(0, mapper.transformedToOriginal(0))
        assertEquals(0, mapper.transformedToOriginal(1))
        assertEquals(0, mapper.transformedToOriginal(2))
        assertEquals(1, mapper.transformedToOriginal(3))
    }

    @Test
    fun `sufijo de un caracter`(){
        val mapper = SuffixOffsetMapping("45")
        assertEquals(0, mapper.originalToTransformed(0))
        assertEquals(1, mapper.originalToTransformed(1))
        assertEquals(2, mapper.originalToTransformed(2))

        assertEquals(0, mapper.transformedToOriginal(0))
        assertEquals(1, mapper.transformedToOriginal(1))
        assertEquals(2, mapper.transformedToOriginal(2))
        assertEquals(2, mapper.transformedToOriginal(3))
        assertEquals(2, mapper.transformedToOriginal(4))
    }
}