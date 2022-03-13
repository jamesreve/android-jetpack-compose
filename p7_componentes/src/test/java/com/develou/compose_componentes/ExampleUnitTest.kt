package com.develou.compose_componentes

import com.develou.compose_componentes.examples.Slider.calculateSegment
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testCalculateSegment() {
        val range = 0F..100F
        val steps = 4

        assertEquals(0F, calculateSegment("", range, steps))
        assertEquals(0F, calculateSegment("0", range, steps))
        assertEquals(0F, calculateSegment("5", range, steps))
        assertEquals(20F, calculateSegment("20", range, steps))
        assertEquals(40F, calculateSegment("30", range, steps))
        assertEquals(60F, calculateSegment("65", range, steps))
        assertEquals(80F, calculateSegment("75", range, steps))
        assertEquals(100F, calculateSegment("400", range, steps))
    }

}