package com.furrow.expression

import com.furrow.expression.operation.OperationType
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class FactoryFunctionTest: ShouldSpec() {
    init {
        should("evaluate 3 + 4 * 5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(3)
                pushValue(4)
                pushValue(5)
                pushOperation(OperationType.MULTIPLICATION)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe 23
        }

        should("evaluate 2 + 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe 5
        }

        should("evaluate 2 * 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MULTIPLICATION)
            }

            factoryFunction.evaluate() shouldBe 6
        }

        should("evaluate 0 + 0") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(0)
                pushValue(0)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe 0
        }

        should("evaluate 12 * 0") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(12)
                pushValue(0)
                pushOperation(OperationType.MULTIPLICATION)
            }

            factoryFunction.evaluate() shouldBe 0
        }

        should("evaluate 2 + -5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(-5)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe -3
        }

        should("evaluate 12 * -5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(12)
                pushValue(-5)
                pushOperation(OperationType.MULTIPLICATION)
            }

            factoryFunction.evaluate() shouldBe -60
        }

        should("evaluate 2 * 3 + 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MULTIPLICATION)
                pushValue(3)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe 9
        }

        should("evaluate 2 * 3 + 4 * 5 * 6") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MULTIPLICATION)
                pushValue(4)
                pushValue(5)
                pushValue(6)
                pushOperation(OperationType.MULTIPLICATION)
                pushOperation(OperationType.MULTIPLICATION)
                pushOperation(OperationType.ADDITION)
            }

            factoryFunction.evaluate() shouldBe 126
        }
    }
}