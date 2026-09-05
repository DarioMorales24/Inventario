# Proyecto de Evaluación DevOps

# Microservicio Gestor de Inventario - Proyecto DevOps

Este repositorio contiene la base de trabajo para nuestro pipeline DevOps. A continuación, se detalla la documentación técnica sobre el uso del repositorio para facilitar la colaboración y calidad del código.

## 1. Metodología de Trabajo y Estrategia de Ramificación
Para este proyecto hemos decidido implementar el modelo **GitFlow**. Ya que con GitFlow el desarrollo se organiza en ramas especificas segun funcionalidad, lo que mejora mucho el control de archivos, subidas, pull request, y sobre todo organizacion, mejorando la separacion del codigo de produccion al entorno de desarrollo.

## 2. Naming de Ramas (Convenciones de Nombres)
El proyecto utiliza la siguiente estructura de ramas:
* **`main`**: Rama principal que contiene el código estable (producción).
* **`develop`**: Rama de desarrollo donde se integran las nuevas funcionalidades.
* **`feature/<nombre-funcionalidad>`**: Ramas temporales creadas a partir de `develop` para trabajar en nuevas características.
* **`hotfix/<nombre-error>`**: Ramas creadas a partir de `main` para resolver correcciones urgentes.

## 3. Convenciones de Mensajes de Commit
Para asegurar la trazabilidad del código fuente, los mensajes de commit deben ser descriptivos.
* **Formato:** `[Acción] Breve descripción del cambio`
* **Ejemplos:** 
  * `git commit -m "feature: Agrega controlador para el inventario"`
  * `git commit -m "hotfix: Corrige error de conexion a base de datos"`

## 4. Flujos de Merge y Estrategia de Revisión
* Está estrictamente prohibido realizar *push* directos a las ramas `main` y `develop`.
* Todo código nuevo o corrección debe integrarse exclusivamente mediante **Pull Requests (PR)**.
* Como estrategia de revisión, cada Pull Request debe ser validado (y aprobar los chequeos automáticos de GitHub Actions) antes de realizar el *Merge* hacia `develop` o `main`.