package com.furrow.expression.operation

import com.furrow.expression.node.ValueNode
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class OperationTest: ShouldSpec() {
    init {
        should("evaluate 2 + 3") {
            Addition(listOf(ValueNode(2), ValueNode(3))).evaluate() shouldBe 5
        }

        should("evaluate 2 * 3") {
            Multiplication(listOf(ValueNode(2), ValueNode(3))).evaluate() shouldBe 6
        }

        should("evaluate 0 + 0") {
            Addition(listOf(ValueNode(0), ValueNode(0))).evaluate() shouldBe 0
        }

        should("evaluate 12 * 0") {
            Multiplication(listOf(ValueNode(12), ValueNode(0))).evaluate() shouldBe 0
        }

        should("evaluate 2 + -5") {
            Addition(listOf(ValueNode(2), ValueNode(-5))).evaluate() shouldBe -3
        }

        should("evaluate 12 * -5") {
            Multiplication(listOf(ValueNode(12), ValueNode(-5))).evaluate() shouldBe -60
        }

        should("evaluate 2 * 3 + 3") {
            Addition(listOf(Multiplication(listOf(ValueNode(2), ValueNode(3))), ValueNode(3))).evaluate() shouldBe 9
        }

        should("evaluate 2 * 3 + 4 * 5 * 6") {
            val results = Addition(listOf(
                    Multiplication(listOf(ValueNode(2), ValueNode(3))),
                    Multiplication(listOf(ValueNode(4),
                            Multiplication(listOf(ValueNode(5), ValueNode(6)))))))
            results.evaluate() shouldBe 126
        }
//
//        should("evaluate adding an Int (2) to a Double (3.5)") {
//            DoubleAddition(IntToDouble(2), ValueNode(3.5)).evaluate() shouldBe 5.5
//        }

    }
}