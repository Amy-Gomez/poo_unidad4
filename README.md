# <p align="center" style="color:#8c0051;"> Finalización del sistema de Contenido Audiovisual </p>

---

## <p style="color:#a64d79;">📝 Descripción del Proyecto</p>

Este proyecto consiste en una aplicación desarrollada en &nbsp;<img width= "50" src= "https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png">diseñada para demostrar la aplicación práctica de la Programación Orientada a Objetos (POO), Patrones de Diseño y Principios SOLID.

El sistema permite gestionar un catálogo multimedia (Películas, Series, Documentales, Videos Musicales y Anuncios), implementando persistencia de datos mediante archivos y una arquitectura desacoplada.

**Características principales:**
* **Persistencia de Datos:** Lectura y escritura automática en archivos CSV.
* **Arquitectura MVC:** Separación estricta entre Modelo, Vista y Controlador.
* **Gestión de IDs:** Generación automática de identificadores y sincronización con la persistencia.
* **Búsquedas:** Filtrado de contenidos por título.
  
---
## <p style="color:#a64d79;">📂 Estructura del Código (Arquitectura MVC)</p>
El proyecto ha sido refactorizado para seguir el patrón **Modelo-Vista-Controlador**, como lo indica la **Etapa 4** organizado en los siguientes paquetes:
```text
src/
├── controlador/
│   └── Controlador.java       # Orquesta la comunicación entre la Vista y el Modelo.
├── modelo/
│   ├── ContenidoAudiovisual.java (Abstracta)
│   ├── Pelicula.java
│   ├── SerieDeTV.java
│   ├── Documental.java
│   ├── VideoMusical.java
│   ├── AnuncioPublicitario.java
│   ├── GestorContenido.java   # Lógica de negocio y gestión de la lista en memoria.
│   ├── IRepositorioContenido.java # Interfaz para aplicar DIP (Inversión de Dependencias).
│   └── (Clases auxiliares: Actor, Investigador, Temporada)
├── vista/
│   └── VistaTerminal.java     # Interfaz de usuario por consola (Scanner).
├── util/
│   └── GestorArchivoCSV.java  # Implementación concreta de lectura/escritura de archivos.
├── poo/
│   └── Main.java              # Punto de entrada (Inyección de dependencias).
└── test/
    └── modelo/
        └── GestorContenidoTest.java # Pruebas Unitarias con JUnit 5.
```
---
## <p style="color:#a64d79;">⭐ Implementaciones y Mejoras Técnicas</p>

### 1. Persistencia de Datos (Manejo de Archivos) [Etapa 1]
Se implementó la clase GestorArchivoCSV en el paquete `util`.

* **Lectura**: Parsea el archivo `contenidos.csv` utilizando el separador `|`. Reconstruye objetos complejos (listas de temporadas, actores, investigadores) a partir de texto plano.
* **Escritura**: Subclase para comerciales. Contiene atributos de contexto importantes, como la **marca** y la **agencia** productora.

### 2. Principios SOLID [Etapa 3]
Se han fortalecido las relaciones entre las clases mediante Agregación, conectando los nuevos contenidos con elementos ya existentes:
* **SRP (Responsabilidad Única)**: La lógica de archivos se movió a `util`, la interacción con usuario a `vista` y el negocio a `modelo`.
* **DIP (Inversión de Dependencia)**: El `GestorContenido` no depende directamente de la clase CSV, sino de la interfaz `IRepositorioContenido`. Esto hace que el sistema sea fácil de probar y extender.

### 3. Refactorización de IDs y Constructores [Etapa 2]
Para solucionar conflictos al cargar datos guardados versus crear nuevos, se implementó una Doble Estrategia de Constructores:
<ol>
<li><b>Constructor con ID</b>: Usado por el parser CSV para respetar los IDs históricos.</li>
<li><b>Constructor sin ID</b>: Usado por el Controlador para nuevos registros; el sistema asigna automáticamente el siguiente ID disponible (basado en un contador estático <code>siguienteID</code>).</li>
</ol>

### 4. Nuevos Tipos de Contenido
Se extendió la jerarquía con clases especializadas que usan Agregación:
* `VideoMusical`: Incluye atributos de artista, álbum y un `Actor` invitado.
* `AnuncioPublicitario`: Gestiona marcas, agencias y un `Actor` protagonista.

---
## <p style="color:#a64d79;">🚀 Clonación y Ejecución</p>

### 1. Establecer Conexión SSH
Mis claves SSH ya estaban generadas, por lo que lo único que hice fue asegurarme de que mi agente SSH estuviera activo y la clave agregada para poder clonar sin problemas:
<pre><code>
# Iniciar el agente en segundo plano
eval "$(ssh-agent -s)"

# Agregar tu clave privada (si no está agregada ya)
ssh-add ~/.ssh/id_ed25519

# Verificar conexión con GitHub
ssh -T git@github.com
</code></pre>

### 2. Clonar el repositorio

1.  En la página del repositorio, haga clic en el botón verde **"Code"**.
    <p align="center">
    <img width="250" alt="Botón Code de GitHub" src="https://docs.github.com/assets/cb-13128/images/help/repository/code-button.png">
    </p>

2.  Copie el enlace SSH proporcionado.
    <p align="center">
    <img width="300" alt="Copia de enlace SSH de GitHub" src="https://itknowledgeexchange.techtarget.com/coffee-talk/files/2022/01/github-key-ssh-url-clone.jpg">
    </p>

3.  Abra **Eclipse IDE**.
4.  Seleccione el menú **`File`** $\rightarrow$ **`Import`**.
    <p align="center">
    <img width="250" alt="Opción Importar en Eclipse" src="https://www.codejava.net/images/articles/ides/eclipse/importprojects/Import%20from%20menu%20File.png">
    </p>

5.  Elija **`Git`** $\rightarrow$ **`Projects from Git`** $\rightarrow$ **`Clone URI`**.
6.  Pega la URL SSH. Eclipse debería detectar tus claves automáticamente si el paso 1 fue exitoso.
7.  Sigue los pasos hasta finalizar (Finish).

### 3. Ejecutar la Aplicación
1. En el explorador de proyectos, navegue al paquete `poo`.
2. Abre el archivo <code>Main.java</code>.
3. Haz clic derecho $\rightarrow$  **Run As** $\rightarrow$  **Java Application**.
4. Interactúe con el menú en la consola:
   * Puede añadir contenido, listar, buscar y eliminar. </li>
   * **IMPORTANTE**: Seleccione la Opción 5 (Guardar y Salir) para que los cambios se escriban en el archivo <code>contenidos.csv</code>. 

---
## <p style="color:#a64d79;">🧪 Etapa 5 (Pruebas Unitarias) </p>
El proyecto incluye pruebas automatizadas con **JUnit 5** para validar la lógica de negocio sin depender de la interfaz de usuario.
1. Navegue a la carpeta de `test`.
2. Localice el paquete `poo` y la clase `PruebaAudioVisual.java`.
3. Haga clic derecho sobre el archivo.
4. Seleccione **Run as** $\rightarrow$  **JUnit Test**

Las pruebas indicaron que se cumplen con los siguientes requisitos:
* Inicialización y carga de datos.
* Generación correcta de IDs consecutivos.
* Adición de contenidos al catálogo.
* Eliminación de contenidos (existentes y no existentes).
* Búsqueda por título.

---
## <p style="color:#a64d79;">📄 Formato del Archivo CSV</p>
El archivo `contenidos.csv` utiliza el carácter `|` como separador para evitar conflictos con textos normales. El formato general es: <br>
<p align="center";><code>TIPO|ID|TITULO|DURACION|GENERO|DETALLES_ESPECIFICOS...</code></p> 

**Ejemplo:**
<pre><code>
PELICULA|1|Forrest Gump|142|Drama|Paramount Pictures|Tom Hanks
SERIE|3|Breaking Bad|50|Crimen/Drama|T1:E7;T2:E13
VIDEO|5|Rock You|240|Pop Rock|The Band|Greatest Hits|Dwayne Johnson
</code></pre>
