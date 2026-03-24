import math

class AlgebraVectorial3D:
    def __init__(self, x=0.0, y=0.0, z=0.0):
        self.x = x
        self.y = y
        self.z = z

    # a) Suma de dos vectores (operador +)
    def __add__(self, other):
        return AlgebraVectorial3D(self.x + other.x, self.y + other.y, self.z + other.z)

    # b) Multiplicación de un escalar por un vector (operador *)
    def __mul__(self, scalar):
        if isinstance(scalar, (int, float)):
            return AlgebraVectorial3D(self.x * scalar, self.y * scalar, self.z * scalar)
        raise ValueError("La multiplicación debe ser por un escalar.")

    # c) Longitud de un vector
    def longitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    # d) Normal de un vector
    def normalizar(self):
        mag = self.longitud()
        if mag == 0:
            return AlgebraVectorial3D(0, 0, 0)
        return AlgebraVectorial3D(self.x / mag, self.y / mag, self.z / mag)

    # e) Producto escalar 
    def productoEscalar(self, other):
        return self.x * other.x + self.y * other.y + self.z * other.z

    # f) Producto vectorial 
    def __matmul__(self, other):
        return AlgebraVectorial3D(
            self.y * other.z - self.z * other.y,
            self.z * other.x - self.x * other.z,
            self.x * other.y - self.y * other.x
        )

    def __repr__(self):
        return f"({self.x}, {self.y}, {self.z})"

if __name__ == "__main__":
    a = AlgebraVectorial3D(1, 2, 3)
    b = AlgebraVectorial3D(4, 5, 6)

    print(f"Vector A: {a}")
    print(f"Vector B: {b}")
    print("-" * 50)
    
    print(f"a) Suma (a + b): {a + b}")
    print(f"b) Escalar (a * 3): {a * 3}")
    print(f"c) Longitud de a: {a.longitud():.2f}")
    print(f"d) Normal de a: {a.normalizar()}")
    print(f"e) Producto Escalar (a · b): {a.productoEscalar(b)}")
    print(f"f) Producto Vectorial (a × b): {a @ b}") # Usamos @ para producto cruz
