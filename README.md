# Java Fullstack

## API Rest para gestionar usuarios construida con Springboot, Hibernate y sesión con JWT.

Esta web nos permitirá registrarnos para acceder a la tabla de usuarios creados.

![1](https://user-images.githubusercontent.com/89553383/154146587-f7d78523-da06-4ada-b07f-ef02c31bc2a5.png)

- Para la sesión usaremos **Jason Web Token**, con el cual nos aseguramos que unicamente un usuario logueado manipule los datos de la tabla.

![5](https://user-images.githubusercontent.com/89553383/154146674-bfada7d1-623c-430c-98ac-0cd601e96184.png)

- Para encriptar las contraseñas de nuestros usuarios usaremos **Argon2**.

![2](https://user-images.githubusercontent.com/89553383/154146836-528dc97a-a4fa-4056-9c5b-a5af5bad2f41.png)

![4](https://user-images.githubusercontent.com/89553383/154146687-9d61fafb-6cc1-4dde-bcd9-8b949f74eec9.png)

- Para gestionar la base de datos y el servidor web usamos **XAMPP**.

## Endpoints:

- GET api/usuarios
- PUT api/usuarios
- DELETE api/usuarios/{id}

## Informacion para levantar y probar el proyecto:
El proyecto esta construido con **Spring**. Maneja sus dependecias con **Maven**. Se trabajo con **IntelliJ Idea** para el backend, pero el proyecto se puede levantar tambien desde Eclipse o NetBeans. Se utilizo **Windows 10** como sistema operativo.

Los pasos previos para correr la webapp son los siguientes:

1- Bajar la version compilada de [Maven](https://maven.apache.org/download.cgi) "apache-maven-3.8.4-bin.zip"

2- Bajar [JDK](https://www.oracle.com/java/technologies/downloads/)

3- Configurar las variables de entorno para poder trabajar con Maven y JDK. Esto lo hacemos desde **Configuracion Avanzada del sistema/Variables de entorno/** donde en **Variables del sistema** crearemos una nueva instancia llamada **MAVEN_HOME** y **JAVA_HOME**. En ambos casos, en **"Valor"** pondremos la direccion donde se encuentran los recursos, tal como muestra la imagen:

![image](https://user-images.githubusercontent.com/89553383/154150081-640104de-8931-4074-8aa9-803116920a18.png)

4- Luego, dentro de **Variables del sistema**, buscaremos **"Path"** y pondremos **Editar**. Dentro de la edicion crearemos a **%MAVEN_HOME%\bin** y **%JAVA_HOME%\bin**

![image](https://user-images.githubusercontent.com/89553383/154150342-322ba865-a3cc-4d99-ab36-8e42de17c524.png)

5- Descargamos [XAMPP](https://www.apachefriends.org/es/index.html) para manejar el servidor web y la base de datos 

6- Una vez instalado XAMPP, buscamos desde su explorador la carpeta **"mysql/data"** 

![image](https://user-images.githubusercontent.com/89553383/154150874-8bc777ff-ab62-4878-ab1a-87a6475c2381.png)

7- Dentro de esa carpeta, descomprimimos el archivo **BASE-DATOS-XAMPP** que se encuentra en la carpeta principal de este repositorio. Nos deberia quedar la siguiente ruta: **Xampp\mysql\data\cursojava**

8- Dentro de XAMPP, corremos los servicios de Apache y Mysql

![image](https://user-images.githubusercontent.com/89553383/154151596-6ccf3de6-f3cb-442c-a33d-542440f2824d.png)

9- Dentro del proyecto de Spring, en Maven corremos a spring-boot:

![image](https://user-images.githubusercontent.com/89553383/154151807-29d65201-b319-4b29-bf71-c13cb0c5dd12.png)

10- Ahora podemos acceder a la webapp desde el browser en el **localhost:8080**. Podemos ver la base de datos en **localhost/phpmyadmin/**
