# Expression Tree

![Expression Tree](documents/expression-tree.png)

The intention of this project is to create a expression tree and evaluate the results but not parse input values.  Another stipulation was to build the project in such a way that was flexible and allowed for modifications to be fairly easy in the future. Because of this condition, you will see one of the design decisions was to use Kotlin's generics to allow for multiple data types. Due to using generics in this way, it required defining similar logic for various numeric types (int, long, etc). While this does add to the maintenance costs, it gives greater flexibility in the types allowed instead of relying on something like a double.

The project is in Kotlin as much Kotlin as possible. It even uses Gradle's Kotlin DSL for its build. Also as a way to test out the new feature, the project uses Github's new Actions as a CI to run the tests.

