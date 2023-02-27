
# JAVA

- Lenguajes compilados vs lenguajes interpretados
  - Lenguaje compilado:
    - Beneficios:
      - El poder tener una fase (compilación) en la que detectamos problemas a priori, sin necesidad de ejecutar el código.
      - Rendimiento, suele ser mejor
    - Puntos negativos:
      - Dificulta la gestión del producto final. Tenemos que generar tantos binarios como SO/arquitecturas de microprocesador vayamos a necesitar.
  - Lenguaje interpretado
    - Puntos negativos:
      - Al no tener una fase de compilación nos perdemos la posibilidad de detectar problemas a priori, sin necesidad de ejecutar el código.
      - Rendimiento, suele ser peor
    - Beneficios:
      - Facilita la gestión del producto final. No tenemos que generar tantos binarios como SO/arquitecturas de microprocesador vayamos a necesitar.
      - Distribuimos un único resultante
  - Java es las dos cosas:

    .java -> javac -> .class -> interpretado -> JVM
                    (byte-code) 

- Lenguajes de tipado estático vs tipado dinámico

  Tipado estático es cuando el lenguaje asocia a cada variable un tipo.
  Tipado dinámico es cuando el lenguaje no asociasa a las variables un tipo... y por ende, una variable puede 

- Paradigmas de programación
  √ Imperativo
    Las lineas de código se van ejecutando en orden secuencial: if, else, for, while 

  √ Programación procedural
    Cuando el lenguaje nos da la posibilidad de crear/definir e invocar funciones/procedimientos/métodos
    BENEFICIO: Reutilizar código / Encapsular código

  √ Programación funcional
    Cuando el lenguaje me permite que una variable apunte a una función!
    Esto cambia todo, ya que desde el momento que una variable puede apuntar a una función, podemos crear funciones que reciban funciones como argumentos.
    También podemos crear funciones que devuelvan funciones.
    ESTE FUE EL GRAN CAMBIO QUE SE INICIO EN JAVA 1.8
    - Paquete java.util.function
    - Se añade un nuevo operador ::
    - Se añade un nuevo tipo de expresiones en el lenguaje: Expresiones lambda
    - Se crea un paquete nuevo llamado java.util.stream

  √ Orientado a objetos 
    Crear mis propios TIPOS de datos, con sus propias funciones/métodos personalizados

    TIPO: String .toUpperCase .toLowerCase .trim 
---
# Variable

Una referencia a un objeto que tenemos en memoria RAM... en la mayoría de los lenguajes --> JAVA
Hay lenguajes en los que una variable es una ubicación en la memoria RAM.

```java
String texto = "Hola";
texto = "adios"; //(2)
texto = 3;     // ERROR
var otroTexto = "Hola";   // La palabra clave var existe en JAVA desde hace 5 o 6 años !!!! Versión 10 de JAVA
        // Aquí tenemos un tipado estático, donde se usa el concepto de INFERENCIA DE TIPOS 
otroTexto = "Adios";      // OK
otroTexto = 3;            // NOK !
```

Cuantas partes tiene ese statement? 3
- "hola"          Crea un objeto de tipo String inicializado con el valor "hola" en la memoria RAM
- String texto    Definir una variable (un nombre) que puede apuntar a textos en la memoria RAM
- =               Asigna la variable al texto "Hola"

Llegados a la linea (2) tenemos 2 objetos en la memoria RAM: "hola"; y el objeto "adios"
En este momento "hola" queda sin referencias. Nadie (ninguna variable) apunta al objeto "hola" -> BASURA (Garbage), que será eliminada por el garbage collector

JAVA hace un muy poco eficiente uso de la memoria RAM. Eso es un bueno o malo? Ni bueno ni malo. Es un feature!

```js 
var texto = "hola"
texto = "adios"     // OK
texto = 3           // OK
```

---
Cuando surje JAVA se iba a usar para todo:

~ Aplicaciones web : 
 √ backend : JAVA (Spring + springboot) 
 x frontend: JS
x Aplicaciones desktop (VSCode)
x Aplicaciones para teléfonos móviles    KOTLIN
x Aplicaciones software embebido         C, C++

KOTLIN? Es una sintaxis alternativa a JAVA para generar byte-code: Apps android
SCALA?  Es una sintaxis alternativa a JAVA para generar byte-code: Mundo bigdata

---

# Cagadas de JAVA:

## los getter y los setter

Mala forma de conseguir encapsulación

---

JEE
Java Enterprise Edition -> Jakarta Enterprise Edition
JDBC
JMS
JPA - Java persistence

--- 

Muerte de JAVA

La compra de Java por parte de Oracle

MySQL --> MariaDB
OpenOffice (-> StarOffice) --> LibreOffice
Hudson --> Jenkins

----

Maven?

- Gestionar el ciclo de vida del proyecto
  - Compilación
  - Ejecución de pruebas
  - Empaquetado
  - Y muchos otros
- Gestionar dependencias

Goles de maven: TAREAS BASICAS QUE PUEDO HACER CON MAVEN:
- compile
- test-compile
- test
- package
- install

---
Maven nos crea una determina estructura de carpetas: (Es personalizable. NADIE LA CAMBIA)

  PROYECTO
   |-src                    Aquí tenemos el código
   |  |-main                Tenemos el proyecto que estoy montando
   |  |   |-java
   |  |   |-resources
   |  |-test                Programas de pruebas de nuestro programa
   |      |-java
   |      |-resources
   |-pom.xml                Es el archivo de configuración de maven para nuestro proyecto

Toda la funcionalidad de maven se consigue mediante plugins

DEV-->OPS
Cultura de la AUTOMATIZACION !

Integración Continua
  Pruebas dinámicas, es cuando ejecuto el software para hacer la prueba
    Pruebas funcionales
    Pruebas no funcionales
  Pruebas estáticas, es cuando NO EJECUTO el software para hacer la prueba
    Pruebas de calidad de código: SONARQUBE


Entornos:
- Desarrollo
- Pre-producción = Pruebas = Q&A = Entorno de Integración
- Producción

---
Interfaz A
- metodo1
- default metodo2 ()

clases que implementan la Interfaz A
Clase B1        Clase B2        Clase B3
metodo1         metodo1         metodo1

proyecto1       proyecto2       proyecto3
----
                                Pool de ejecutores
Trabajo 1                       Ejecutor 1
Trabajo 2                       Ejecutor 2
Trabajo 3
Trabajo n
