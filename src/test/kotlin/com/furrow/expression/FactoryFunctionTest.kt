package com.furrow.expression

import com.furrow.expression.exception.OperationException
import com.furrow.expression.operation.OperationType
import io.kotlintest.matchers.doubles.shouldBeBetween
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.ShouldSpec
import java.lang.RuntimeException

class FactoryFunctionTest: ShouldSpec() {
    init {
        should("evaluate 3 + 4 * 5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(3)
                pushValue(4)
                pushValue(5)
                pushOperation(OperationType.MultiplicationType())
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe 23
        }

        should("evaluate 2 + 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe 5
        }

        should("evaluate 2 * 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MultiplicationType())
            }

            factoryFunction.evaluate() shouldBe 6
        }

        should("evaluate 0 + 0") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(0)
                pushValue(0)
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe 0
        }

        should("evaluate 12 * 0") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(12)
                pushValue(0)
                pushOperation(OperationType.MultiplicationType())
            }

            factoryFunction.evaluate() shouldBe 0
        }

        should("evaluate 2 + -5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(-5)
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe -3
        }

        should("evaluate 12 * -5") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(12)
                pushValue(-5)
                pushOperation(OperationType.MultiplicationType())
            }

            factoryFunction.evaluate() shouldBe -60
        }

        should("evaluate 2 * 3 + 3") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MultiplicationType())
                pushValue(3)
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe 9
        }

        should("evaluate 2 * 3 + 4 * 5 * 6") {
            val factoryFunction = FactoryFunction<Int>()
            factoryFunction.apply {
                pushValue(2)
                pushValue(3)
                pushOperation(OperationType.MultiplicationType())
                pushValue(4)
                pushValue(5)
                pushValue(6)
                pushOperation(OperationType.MultiplicationType())
                pushOperation(OperationType.MultiplicationType())
                pushOperation(OperationType.AdditionType())
            }

            factoryFunction.evaluate() shouldBe 126
        }

        should("evaluate 6 / 3") {
            val factoryFunction = FactoryFunction<Double>()
            factoryFunction.apply {
                pushValue(6.0)
                pushValue(3.0)
                pushOperation(OperationType.DivisionType())
            }

            factoryFunction.evaluate() shouldBe 2.0
        }

        should("handle division by 0") {
             val factoryFunction = FactoryFunction<Double>()
            factoryFunction.apply {
                pushValue(6.0)
                pushValue(0.0)
                pushOperation(OperationType.DivisionType())
            }

            shouldThrow<OperationException> {
                factoryFunction.evaluate()
            }
        }
    }
}