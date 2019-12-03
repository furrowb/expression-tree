package com.furrow.expression.operation

import com.furrow.expression.FactoryFunction
import com.furrow.expression.exception.OperationException
import com.furrow.expression.node.ValueNode
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.ShouldSpec

class OperationTest: ShouldSpec() {
    init {
        listOf(
            OperationType.AdditionType<Boolean>(),
            OperationType.DivisionType<Boolean>(),
            OperationType.MultiplicationType<Boolean>()
        ).forEach { type ->
            should("throw exception for unknown type for ${type.name()}") {
                val factoryFunctionTest = FactoryFunction<Boolean>()
                factoryFunctionTest.pushValue(true)
                factoryFunctionTest.pushValue(false)
                factoryFunctionTest.pushOperation(type)
                shouldThrow<OperationException> {
                    factoryFunctionTest.evaluate()
                }
            }
        }

        should("use a ValueNode's description") {
            val node = ValueNode<Boolean>(false);
            node.description() shouldBe "Node's value: false"
        }

        listOf(
            Addition(listOf(ValueNode(1))),
            Multiplication(listOf(ValueNode(1))),
            Division(listOf(ValueNode(1)))
        ).forEach {
            should("throw an exception when when they aren't enough operands for ${it.description()}") {
                shouldThrow<OperationException> {
                    it.evaluate()
                }
            }
        }
    }
}