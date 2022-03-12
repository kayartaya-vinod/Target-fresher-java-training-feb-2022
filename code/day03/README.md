# Topics for the day:

-   OOP - Abstraction, encapsulation, modularity, hierarchy
-   Methods Overriding, Overloading
-   Abstract methods and classes, interfaces, polymorphism
-   Packages and Access Control

## Major (4) and minor (3) elements of OOP as per Grady Booch

### Major elements

1. Abstraction - Hide implementation details (create classes and interfaces)
2. Modularity - Using smaller modules (unit of code) to compose a bigger application
3. Encapsulation - Restricting access to some members of the abstraction
4. Hierarchy - Arrangement of classes in an application by their relationship
    - Emphasize on code reusability
        - Aggregation/ Composition --> HAS-A (Whole/Part)
        - Inheritance --> IS-A (Parent/child, Base/derived, Super/sub, Generalization/Sepcialization)
            - Side effect of inheritance is polymorphsim
        - Association --> USES-A (method parameters or return values)

### Minor elements

1. Typing - Strcit enforcement of datatypes on variables/ methods
2. Concurrency - Ability to run multiple flow controls - Threads
3. Persistence - Ability of an object to save it's state and restore later

## Some important pointers:

-   "abstract" methods can only be in an abstract class
-   abstract classes cannot be used for creating an object
    -   this means, that the abstract class is useless unless inherited, and the subclasses are forced to override/implement the abstract methods
-   abstract classes encourage inheritance
-   If a method is marked as "final", then it cannot be overridden in a subclass
-   If a class is marked as "final", then it cannot be used for a superclass
    -   this means that "final" discourages inheritance
-   final and abstract cannot be used together for a given identifier
-   "final" can also be used with variables

    -   they can be assigned only once
    -   need not be assigned during declaration, but once assigned, cannot be changed

-   Inheritance is all and only about code reusability
-   Interfaces is about polymorphism and enforcing contracts on classes
    -   loose coupling between different layers of the application
