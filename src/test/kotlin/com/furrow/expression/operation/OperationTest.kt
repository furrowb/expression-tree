package com.furrow.expression.operation

import com.furrow.expression.node.ValueNode
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class OperationTest: ShouldSpec() {
    init {
        should("evalute 2 + 3") {
            IntAddition(ValueNode(2), ValueNode(3)).evaluate() shouldBe 5
        }

        should("evaluate 2 * 3") {
            IntMultiplication(ValueNode(2), ValueNode(3)).evaluate() shouldBe 6
        }

        should("evaluate 0 + 0") {
            IntAddition(ValueNode(0), ValueNode(0)).evaluate() shouldBe 0
        }

        should("evaluate 12 * 0") {
            IntMultiplication(ValueNode(12), ValueNode(0)).evaluate() shouldBe 0
        }

        should("evaluate 12 + -5") {
            IntAddition(ValueNode(2), ValueNode(-5)).evaluate() shouldBe -3
        }

        should("evaluate 12 * -5") {
            IntMultiplication(ValueNode(12), ValueNode(-5)).evaluate() shouldBe -60
        }

        should("evaluate 2 * 3 + 3") {
            IntAddition(IntMultiplication(ValueNode(2), ValueNode(3)), ValueNode(3)).evaluate() shouldBe 9
        }

        should("evaluate 2 * 3 + 4 * 5 * 6") {
            val results = IntAddition(
                    IntMultiplication(ValueNode(2), ValueNode(3)),
                    IntMultiplication(ValueNode(4),
                            IntMultiplication(ValueNode(5), ValueNode(6))))
            results.evaluate() shouldBe 126
        }
    }
}