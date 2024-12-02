# Buscador de Libros

Este proyecto es una aplicación basada en Java que permite buscar libros mediante una API, gestionar una base de datos local de libros y autores, y realizar consultas específicas sobre los datos.

## Funcionalidades

1. **Buscar por Título**  
   Permite buscar un libro por su título a través de la API y almacenarlo en la base de datos si aún no está registrado.  
   - Mensaje si el libro ya está guardado.  
   - Guardado automático si el libro no existe en la base de datos.  
   
   **Ejemplo de uso:**  
   ```text
   Ingrese el nombre del libro que desea buscar:
   > Orgullo y Prejuicio
   Libro encontrado: Orgullo y Prejuicio
   El libro ya está guardado en la base de datos.

![image](https://github.com/user-attachments/assets/e2bf464e-9d24-4290-8655-dedf1d15d23d)

![image](https://github.com/user-attachments/assets/8508c5da-7348-4a53-bdfa-e99ecad8eec7)

2 
Listar Libros Registrados
Muestra todos los libros almacenados en la base de datos, incluyendo su título y el número de descargas.

*** Libros Registrados ***
Título                                               | Descargas
================================================================
Orgullo y Prejuicio                                  |       500

![image](https://github.com/user-attachments/assets/d09a8d74-b34f-4153-8725-95c4f545d28d)

3
Listar Autores Registrados
Muestra todos los autores asociados a los libros registrados, junto con su fecha de nacimiento.


*** Autores Registrados ***
Nombre                                               | Fecha de nacimiento
===========================================================================
Jane Austen                                          | 1775-12-16


![image](https://github.com/user-attachments/assets/8fbba186-df76-47a9-a342-0a0265f16007)


4 
Listar Autores Vivos en un Año Determinado
Busca autores vivos en un año específico, considerando un rango de 10 años.


Ingrese el año de nacimiento del autor:
> 1900
Autores vivos en el año 1900:
Gabriel García Márquez - Año de nacimiento: 1927



![image](https://github.com/user-attachments/assets/6aad43f6-8a61-4f35-8648-7f5ad8aee82f)

5
Muestra los libros registrados en un idioma específico (por ejemplo, en para inglés o es para español).

 *** Libros Registrados ***
Título                                               | Idiomas
================================================================
Don Quijote                                          | es
Moby Dick                                            | en


![image](https://github.com/user-attachments/assets/0821f86a-3739-4311-957a-be3982c2c8f7)

