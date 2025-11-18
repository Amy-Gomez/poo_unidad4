# <p align="center" style="color:#8c0051;"> Modelado de Contenido Audiovisual (POO Java)</p>

---

## <p style="color:#a64d79;">📝 Descripción del Proyecto</p>

Este proyecto consiste en una aplicación desarrollada en &nbsp;<img width= "50" src= "https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png"> cuyo objetivo primordial es la demostración y aplicación práctica de los pilares fundamentales de la Programación Orientada a Objetos (POO).

Se implementa un modelo de datos que ilustra con claridad conceptos como:
* Herencia
* Polimorfismo
* Las diversas relaciones entre clases (Asociación, Agregación y Composición).

---

## <p style="color:#a64d79;"> Objetivos y Propósito</p>

### <p style="color:#b45f06;">Objetivo:</p>
Crear una jerarquía de clases robusta y extensible para manejar diversos tipos de contenidos audiovisuales (películas, series, documentales, etc.) de manera coherente.
<p align= "center"><img align="center" width="300" src="https://www.elpublicista.es/adjuntos/fichero_18406_20181113.jpg"></pr>

### <p style="color:#b45f06;">Propósito:</p>
La aplicación sirve como un ejercicio formativo esencial para la implementación y comprensión de los siguientes conceptos avanzados:

* Clases abstractas.
* Implementación de la Herencia para la especialización de tipos de contenido.
* Uso del Polimorfismo para manejar objetos de distintas clases de manera uniforme.
* Modelado de relaciones complejas entre objetos, con énfasis en la Agregación a través de clases auxiliares.

---
## <p style="color:#a64d79;">⭐ Novedades y Mejoras Implementadas</p>

### 1. Nuevas Clases y Extensión de la Jerarquía
Se ha expandido la jerarquía principal de clases agregando nuevas especializaciones que heredan de `ContenidoAudiovisual`, promoviendo la extensibilidad del modelo y el uso avanzado del polimorfismo.

* **`VideoMusical`**: Subclase especializada en contenido musical. Añade atributos como el **artista** y el **álbum**.
* **`AnuncioPublicitario`**: Subclase para spots comerciales. Incluye atributos de contexto como la **marca** y la **agencia** productora.

### 2. Implementación de Relaciones Avanzadas (Agregación)
Se han fortalecido las relaciones entre las clases mediante Agregación, conectando los nuevos contenidos con elementos ya existentes:

* Se agregó la clase auxiliar **`Actor`** a las nuevas subclases. `VideoMusical` ahora tiene un **Actor Invitado** y `AnuncioPublicitario` tiene un **Protagonista**.
* Se completaron y actualizaron las clases **`Actor`**, **`Investigador`** y **`Temporada`**, que actúan como componentes clave de otras clases principales.

### 3. Mejora de Código
* Se implementó una **verificación de nulidad (`!= null`)** en los métodos `mostrarDetalles()` de las clases compuestas (`Pelicula`, `Documental`, `VideoMusical`, etc.). Esto asegura que el programa no falle (`NullPointerException`) al intentar acceder a los detalles de un objeto auxiliar que no ha sido inicializado.

---
## <p style="color:#a64d79;"> Configuración del Entorno</p>

### 1. Instalación de Git

Diríjase al sitio oficial de [Git](https://git-scm.com/install/windows) y proceda con la descarga. Ejecute el archivo y siga las indicaciones predeterminadas ("Siguiente") hasta completar la instalación.

### 2. Guía para clonar el repositorio

1.  En la página del repositorio, haga clic en el botón verde **"Code"**.
    <p align="center">
    <img width="250" alt="Botón Code de GitHub" src="https://docs.github.com/assets/cb-13128/images/help/repository/code-button.png">
    </p>

2.  Copie el enlace HTTPS proporcionado.
    <p align="center">
    <img width="300" alt="Copia de enlace HTTPS de GitHub" src="https://docs.github.com/assets/cb-81898/images/help/repository/remotes-url-global-nav-update.png">
    </p>

3.  Abra **Eclipse IDE**.
4.  Seleccione el menú **`File`** $\rightarrow$ **`Import`**.
    <p align="center">
    <img width="250" alt="Opción Importar en Eclipse" src="https://www.codejava.net/images/articles/ides/eclipse/importprojects/Import%20from%20menu%20File.png">
    </p>

5.  Elija **`Git`** $\rightarrow$ **`Projects from Git`** $\rightarrow$ **`Clone URI`**.
6.  Pegue el enlace copiado en el campo `URI`.
7.  Presione **"Next"** y, posteriormente, **"Finish"**.

Una vez completada la importación, el proyecto estará disponible en su espacio de trabajo, listo para comenzar a trabajar.

---

## <p style="color:#a64d79;"> Conexión del Proyecto a GitHub (Uso de Claves SSH)</p>

### 1. Creación del Repositorio Remoto
Para empezar, cree el repositorio en GitHub:
1.  De clic en su foto de perfil $\rightarrow$ **`Repositories`** $\rightarrow$ **`New`**.
    <p align="center">
    <img width="300" alt="Crear nuevo repositorio en GitHub" src="https://desarrolloweb.com/archivoimg/general/3794.png">
    </p>
2.  Complete los campos (Nombre, descripción, visibilidad, etc.) y haga clic en **"Create Repository"**.

### 2. Generación y Configuración de Clave SSH

La autenticación mediante clave SSH es el método recomendado para vincular de forma segura su proyecto local con el repositorio remoto.

1.  Abra la **consola de Git** (Git Bash).
2.  Verifique la existencia previa de claves: `ls -a ~/.ssh`
3.  Si no existe el directorio, créelo: `mkdir .ssh`
4.  Genere la clave SSH:
    ```bash
    ssh-keygen -t ed25519 -C "su-correo-github@ejemplo.com"
    ```
    > El algoritmo `ed25519` es una solución criptográfica moderna de alta seguridad. Asegúrese de usar el correo electrónico vinculado a su cuenta de GitHub.

5.  Se le solicitará el nombre del archivo (dejar por defecto es común) y una **contraseña (passphrase)**.
6.  Inicie el agente SSH: `eval 'ssh-agent -s'`
    > Este agente gestiona las claves privadas en segundo plano para evitar ingresar la contraseña en cada conexión.

7.  Añada la clave privada al agente: `ssh-add ~/.ssh/id_ed25519`
8.  Copie la clave pública al portapapeles: `clip < ~/.ssh/id_ed25519.pub`
9.  Finalmente, en GitHub: Perfil $\rightarrow$ **`Settings`** $\rightarrow$ **`SSH and GPG keys`** $\rightarrow$ **`New SSH key`**. Pegue la clave que había copiado,
    después en "Add SSH Key" y listo
   ---
 ## 🔒 Generación del Token de Acceso Personal (PAT)

Debido a las políticas de seguridad de GitHub, las operaciones que utilizan el protocolo **HTTPS** (como sincronizar cambios desde Eclipse) ya no aceptan la contraseña de la cuenta. En su lugar, se requiere un **Token de Acceso Personal (PAT)** para la autenticación.

A continuación, se detalla el proceso para generar y usar esta credencial:

### 1. Navegación en la Interfaz de GitHub 

1.  Acceda a la configuración de su cuenta en GitHub: Haga clic en su foto de perfil $\rightarrow$ **`Settings`** (Configuración).
2.  En el menú lateral, diríjase a **`Developer settings`** (Configuración de desarrollador).
3.  Seleccione **`Personal access tokens`** $\rightarrow$ **`Tokens (classic)`**.
4.  Haga clic en el botón **`Generate new token`** (Generar nuevo token).

### 2. Configuración de los Parámetros del Token 

Al generar el nuevo token, se establecen sus permisos y vigencia:

* **Note (Nombre):** Asigne un nombre descriptivo (ej. "Token-Eclipse-POO") para identificar su propósito.
* **Expiration (Expiración):** Defina la fecha de caducidad del token (se recomienda establecer un límite de tiempo por seguridad).
* **Scopes (Alcances o Permisos):** Marque los permisos específicos. Para tareas de desarrollo estándar (`push`, `pull`, `fetch`), es esencial seleccionar el alcance de **`repo`**.

### 3. Generación y Almacenamiento 

1.  Una vez definidos los parámetros, haga clic en **`Generate token`**.
2.  GitHub mostrará el PAT **una única vez**. **Es obligatorio copiar este código inmediatamente** y guardarlo en un gestor de contraseñas seguro, ya que si se pierde, deberá generar uno nuevo.

### 4. Uso del PAT en Eclipse 🔑

Al realizar la primera operación de Git (por ejemplo, un `push` o `pull`) desde Eclipse usando la URL HTTPS, el IDE solicitará credenciales. En el campo de la contraseña, se debe ingresar el **Token de Acceso Personal** generado, en lugar de la contraseña de la cuenta de GitHub.
