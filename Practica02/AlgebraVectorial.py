import math

class AlgebraVectorial:
    def __init__(self, x=0.0, y=0.0, z=0.0):
        self.x = float(x)
        self.y = float(y)
        self.z = float(z)

    # --- MÉTODOS AUXILIARES ---
    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    def punto(self, b):
        return self.x * b.x + self.y * b.y + self.z * b.z

    def cruz(self, b):
        return AlgebraVectorial(
            self.y * b.z - self.z * b.y,
            self.z * b.x - self.x * b.z,
            self.x * b.y - self.y * b.x
        )

    # --- (1) DETERMINAR SI SON PERPENDICULARES ---
    def perpendicular(self, b, metodo="c"):
        # a) |a + b| = |a - b|
        if metodo == "a":
            vectorSuma = AlgebraVectorial(self.x + b.x, self.y + b.y, self.z + b.z)
            vectorResta = AlgebraVectorial(self.x - b.x, self.y - b.y, self.z - b.z)
            return math.isclose(vectorSuma.magnitud(), vectorResta.magnitud())
        # b) |a - b| = |b - a|
        elif metodo == "b":
            ab = AlgebraVectorial(self.x - b.x, self.y - b.y, self.z - b.z)
            ba = AlgebraVectorial(b.x - self.x, b.y - self.y, b.z - self.z)
            return math.isclose(ab.magnitud(), ba.magnitud())
        # c) a · b = 0
        elif metodo == "c":
            return math.isclose(self.punto(b), 0.0, abs_tol=1e-9)
        # d) |a + b|^2 = |a|^2 + |b|^2
        elif metodo == "d":
            izq = AlgebraVectorial(self.x + b.x, self.y + b.y, self.z + b.z).magnitud()**2
            der = self.magnitud()**2 + b.magnitud()**2
            return math.isclose(izq, der)
        return False

    # --- (2) DETERMINAR SI SON PARALELOS ---
    def paralela(self, b, r=None):
        # e) a = rb
        if r is not None: 
            return math.isclose(self.x, r*b.x) and math.isclose(self.y, r*b.y) and math.isclose(self.z, r*b.z)
        # f) a x b = 0
        else: 
            return math.isclose(self.cruz(b).magnitud(), 0.0, abs_tol=1e-9)

    # --- (3) DETERMINAR PROYECCIÓN ---
        # g) 
    def proyeccion(self, b):
        magnitudB = b.magnitud()**2
        if magnitudB == 0: return "Indefinida"
        escalar = self.punto(b) / magnitudB
        return f"({escalar*b.x:.2f}, {escalar*b.y:.2f}, {escalar*b.z:.2f})"

    # --- (4) DETERMINAR COMPONENTE  ---
        # h)
    def componente(self, b):
        if b.magnitud() == 0: return 0.0
        return round(self.punto(b) / b.magnitud(), 2)


if __name__ == "__main__":
    # Definimos dos vectores para probar
    A = AlgebraVectorial(3, 0, 0)
    B = AlgebraVectorial(0, 3, 0)

    print(f"Vector A: ({A.x}, {A.y}, {A.z})")
    print(f"Vector B: ({B.x}, {B.y}, {B.z})")
    print("-" * 50)

    # 1. Determinamos si son perpendiculares (usando método c por defecto)
    if A.perpendicular(B):
        print("1. Perpendicularidad: ¡Sí! Los vectores son perpendiculares (forman 90°).")
    else:
        print("1. Perpendicularidad: No, los vectores no son perpendiculares.")

    # 2. Determinamos si son paralelos
    if A.paralela(B):
        print("2. Paralelismo: ¡Sí! Los vectores son paralelos.")
    else:
        print("2. Paralelismo: No, los vectores no son paralelos.")

    # 3. Resultado de cálculos de la proyeccion
    print(f"3. La proyección de A sobre B es: {A.proyeccion(B)}")

    # 4. Resultado de cálculos del componente de a en b.
    print(f"4. El componente de A en dirección de B es: {A.componente(B)}")
