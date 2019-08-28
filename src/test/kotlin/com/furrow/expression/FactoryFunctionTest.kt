package com.furrow.expression

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class FactoryFunctionTest: ShouldSpec() {
    init {
        should("evaluate 3 + 4 * 5 = 23") {
            val factoryFunction = FactoryFunction()
            factoryFunction.evaluate() shouldBe 23
            println("Do the thing!")
        }
    }
}