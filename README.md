# Proyecto DevOps test

El proyecto fue realizado con Java 21 y el framework SpringBoot versión 3.3.4

# Despliegue de la aplicación

Para desplegar la aplicación, se tienen dos ambientes:

- Desarrollo
- Producción

Los ambientes fueron deplegados haciendo uso de plantillas de Terraform, el respositorio es el siguiente: [iac-devops.git](https://github.com/bemeza1998/iac-devops.git)

También se hizo uso de una base de datos NoSQL desplegada en Atlas de MongoDB, con el fin de poder generar JWT en base a autenticación de usuarios y roles.

# Estructura del proyecto

Se definió la siguientes estructura de carpetas para el proyecto:

## Directorio model

Se definió una clase necesaria para interactuar y mapear los objetos recibidos por la base de datos, además de las clases para las respuestas enviadas por el API.

## Directorio utils

Se definieron las clases para la gestión del JWT, y también para el manejo de autenticación de los usuarios y mapearlos a las clases internas de seguridad web de Springboot.

## Directorio resources

Se definieron los endpoint con los que es posible autenticarse y enviar el mensaje.

## Directorio config

Configuraciones de filtros que aplica JWT en las peticiones web recibidas, así mismo se configuró la seguridad web del API.

## Directorio dao

Se definió un repositorio para la lectura de usuarios de la base de datos.

# Archivo Dockerfile

En este archivo, se definió la estructura del contenedor para la aplicación, en la que primero se empaquetará haciendo uso de Maven, y luego se ejecutará el jar creado con Java 21.

# Archivo azure-pipeline.yml

Definición de la canalización para el despliegue por ambiente de la aplicación contenerizada en un app service de Azure.

Se definieron tres stages:

- Build application: Se realiza el seteo de variables secretas en la aplicación para luego, proceder a construir el contenedor de Docker.

- Test application: Se implementa un contenedor temporal donde se realizan las pruebas unitarias y luego, se extraer los resultados de las pruebas para publicarlas en Azure DevOps, donde se podrá visualizar los test y la cobertura del código.

- Deploy: Se realiza al despliegue del contenedor en un app service de Azure.
