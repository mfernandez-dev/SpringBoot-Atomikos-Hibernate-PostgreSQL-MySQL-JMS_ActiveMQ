# SpringBoot-Atomikos-Hibernate-PostgreSQL-MySQL

En esta practica se muestra como realizar un CRUD basico con bases de datos distribuidas. Dichas bases de datos estan instanciadas en motores distintos. Una esta en MySQL y otra en PostgreeSQL. El proyecto está creado con Spring Boot, la conexion a la base de datos se realiza con atomikos y de la persistencia se encarga hibernate. Por ultimo, la aplicacion usa Thymeleaf para las vistas.

## Construido con 🛠️

* Java 8
* Intellj IDEA - IDE
* Spring Boot
* Atomikos
* Hibernate
* PostgreSQL
* MySql

## Instalación/Configuracion 🔧

Para obtener una copia funcional de este proyecto y poder trabajar con el es necesario disponer de los servidores locales de bases de datos, MySql y PostgreSQL y crear las bases de datos y tablas. En la carpeta doc se encuentran los Scripts necesarios para la creacion de cada una de las tablas.

Una vez creadas las tablas habra que adaptar la configuracion del proyecto a las credenciales de la base de datos que se va usar. Dicha configuracion se cambia en las clases DireccionConfig.java y PersonaConfig.java. LAS CONFIGURACIONES NO SON INTERCAMBIALES. PersonaConfig se corresponde con configuracion MySql y DireccionConfig con la configuracion de PostgreeSql.

Una vez configurado esto el programa deberia ejecutar sin problema.

