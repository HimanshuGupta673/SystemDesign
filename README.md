### Strategy Design Pattern vs. Bridge Design Pattern

#### Strategy Design Pattern
The Strategy Pattern is a behavioral design pattern that allows you to define a family of algorithms, put each of them into a separate class, and make their objects interchangeable. It lets the algorithm vary independently from the clients that use it.

#### Bridge Design Pattern
The Bridge Pattern is a structural design pattern that separates an object's abstraction from its implementation, allowing them to vary independently. It decouples the interface from the implementation, promoting flexibility and scalability.

### Key Differences
1. **Purpose**:
   - **Strategy Pattern**: Used to select an algorithm at runtime.
   - **Bridge Pattern**: Used to separate abstraction from implementation so they can change independently.

2. **Focus**:
   - **Strategy Pattern**: Focuses on how behavior is implemented and swapped dynamically.
   - **Bridge Pattern**: Focuses on separating abstraction and implementation into different class hierarchies.

3. **Use Case**:
   - **Strategy Pattern**: Best used when you have multiple ways to perform an operation and you need to switch between them.
   - **Bridge Pattern**: Best used when you need to vary both an abstraction and its implementation independently.

#### Strategy Pattern Example

```
+------------------+       +------------------+
|    Character     |       | MovementStrategy |
|------------------|       |------------------|
| - movement: Move |<----->| + move(): void   |
| + move()         |       +------------------+
| + setMovement()  |                /\
+------------------+                |
                                   |
                       +-----------+-----------+
                       |           |           |
              +--------+--------+  +--------+--------+  +--------+--------+
              |      Walk       |  |      Run        |  |      Fly        |
              |-----------------|  |-----------------|  |-----------------|
              | + move(): void  |  | + move(): void  |  | + move(): void  |
              +-----------------+  +-----------------+  +-----------------+
```

#### Bridge Pattern Example

```
+-----------------+            +-----------------+
|  LivingOrganism |            |  BreatheMethod  |
|-----------------|            |-----------------|
| -breatheMethod  |<>----------| +breathe(): void|
| +setBreatheMethod()          +-----------------+
| +performBreathe(): void      /|\
+-----------------+             |
       /|\                      |
        |                       |
+-------+--------+    +---------+---------+
|      Dog       |    |  LandBreathe      |
+----------------+    +-------------------+
| +Dog()         |    | +breathe()        |
+----------------+    +-------------------+
        |
+-------+--------+    +-------------------+
|      Tree      |    | WaterBreathe      |
+----------------+    +-------------------+
| +Tree()        |    | +breathe()        |
+----------------+    +-------------------+
        |
+-------+--------+    +-------------------+
|      Fish      |    |  TreeBreathe      |
+----------------+    +-------------------+
| +Fish()        |    | +breathe()        |
+----------------+    +-------------------+
```

### Command Design Pattern
The Command Design Pattern is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation allows you to parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

### Key Concepts

1. **Command**: This is an interface or abstract class that declares a method for executing a command. It can also have a method for undoing the command.
2. **Concrete Command**: These are classes that implement the Command interface. They contain a reference to a receiver object and implement the execute method by calling the corresponding action(s) on the receiver.
3. **Receiver**: The object that performs the actual work when the command's execute method is called.
4. **Invoker**: The object that holds a command and at some point asks the command to carry out a request by calling its execute method.
5. **Client**: The client is responsible for creating the command object and associating it with the receiver.

### How It Works

1. **Client creates a command**: The client creates an instance of a concrete command and passes it to the invoker.
2. **Invoker stores the command**: The invoker stores the command object. It doesn't know what the command does, just that it can be executed.
3. **Invoker triggers the command**: When the invoker is asked to perform an action, it calls the execute method on the stored command.
4. **Command calls receiver**: The command object calls methods on the receiver to fulfill the request.


### MVC Design Pattern

The MVC (Model-View-Controller) design pattern is a way to organize code in a Java application to separate concerns, making the application easier to manage, test, and maintain. Here's a simple breakdown:

1. **Model**:
   - Represents the data and the business logic of the application.
   - It directly manages the data, logic, and rules of the application.
   - For example, in a library application, the `Book` class and methods to add, remove, or update books would be part of the Model.

2. **View**:
   - Represents the user interface (UI) of the application.
   - It displays the data from the Model to the user and sends user commands to the Controller.
   - For example, the web pages or graphical user interfaces (GUIs) that show lists of books would be part of the View.

3. **Controller**:
   - Acts as an intermediary between the Model and the View.
   - It listens to the user input from the View, processes it (e.g., updating data in the Model), and updates the View accordingly.
   - For example, if a user clicks a button to add a new book, the Controller handles this action by updating the Model and then refreshing the View.

