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

