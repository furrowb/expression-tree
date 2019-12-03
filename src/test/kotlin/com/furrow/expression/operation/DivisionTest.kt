package com.furrow.expression.operation

import com.furrow.expression.exception.OperationException
import com.furrow.expression.node.ValueNode
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.ShouldSpec
import java.lang.IllegalArgumentException

class DivisionTest: ShouldSpec() {
    init {
        should("handle division by 0 for Double") {
            val division = Division<Double>(listOf(ValueNode(6.0), ValueNode(0.0)))

            shouldThrow<IllegalArgumentException> {
                division.evaluate()
            }
        }

        should("handle division by 0 for Int") {
            val division = Division<Int>(listOf(ValueNode(6), ValueNode(0)))

            shouldThrow<IllegalArgumentException> {
                division.evaluate()
            }
        }

        should("handle division by 0 for Long") {
            val division = Division<Long>(listOf(ValueNode(6L), ValueNode(0L)))

            shouldThrow<IllegalArgumentException> {
                division.evaluate()
            }
        }

        should("divide 6 / 3") {
            val division = Division<Int>(listOf(ValueNode(6), ValueNode(3)))

            division.evaluate() shouldBe 2
        }

        should("divide 6L / 3L") {
            val division = Division<Long>(listOf(ValueNode(6L), ValueNode(3L)))

            division.evaluate() shouldBe 2
        }
    }
}