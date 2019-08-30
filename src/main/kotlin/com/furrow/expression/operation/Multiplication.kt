package com.furrow.expression.operation

import com.furrow.expression.node.Node
import java.lang.RuntimeException

class Multiplication<T>(params: List<Node<T>>?): Node<T>(params) {

    override fun description(): String = "*"

    // Suppressing warnings as we are explicitly checking for type T, verifying
    // what it is and then returning it back to T (which is what it was).
    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun evaluate(): T {
        if(params?.size != OperationType.MULTIPLICATION.numOfOperands) {
            throw RuntimeException("Invalid number of parameters for ${description()}: ${params?.size}")
        }
        val firstParamResult = params[0].evaluate()
        val secondParamResult = params[1].evaluate()
        // Since we know the first parameter is type X, then all of them will be
        return when(firstParamResult) {
            is Int -> firstParamResult * secondParamResult as Int
            is Long -> firstParamResult * secondParamResult as Long
            is Double -> firstParamResult * secondParamResult as Double
            else -> throw RuntimeException("Unknown type being for ${description()}")
        } as T
    }
}