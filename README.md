# API Rest Calculator

Microservicio que consiste en la implementación de una calculadora (API Rest). Desarrollado con SpringBoot. 

Aunque está abierta a nuevas funcionalidades, actualmente implementa las operaciones de Suma, Resta como se pedía y además se ha añadido la multiplicación para comprobar que cumple con el principio O/C.

### Estructura del proyecto

| Package                                   | Descripción 																							 |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------|
| com.proyectoscvr.calculator.api 			| Incluye el controlador CalculatorController así como los Data Transfer Object OperationDTO y ErrorDTO. |
| com.proyectoscvr.calculator.configuration | Incluye el archivo de configuración del proyecto.														 |
| com.proyectoscvr.calculator.exceptions    | Incluye el controlador que se encarga del manejo de excepciones y excepciones propias del proyecto.    |
| com.proyectoscvr.calculator.operations    | Incluye la interfaz IOperation y sus diferentes implementaciones (Suma, resta y multiplicación).		 |    
| com.proyectoscvr.calculator.service 		| Incluye el servicio que se encarga de ejecutar las diferentes operaciones implementadas.				 |
| com.proyectoscvr.calculator.tracer 		| Clase que implementa la interfaz TracerAPI.															 |

### Dependencias utilizadas
Se han utilizado **spring-boot-starter-web**, **spring-boot-starter-test**, **spring-boot-starter-validation** y **spring-boot-maven-plugin** de org.springframework.boot para la creación, pruebas y validación de campos de entrada de la API Rest.
Se ha utilizado **springdoc-openapi-ui** para la documentación de la API.
Se ha utilizado **lombok** para simplificar el desarrollo y mejorar la legibilidad del código.
Se ha utilizado **io.corp.tracer** para "tracear" las ejecuciones de nuestra aplicación.

### Funcionalidades implementadas
Se han implementado las operaciones de SUMA, RESTA y MULTIPLICACIÓN pero el servicio se ha desarrollado de tal modo que puedan añadirse nuevas operaciones sin que haya que modificar el código ya existente (OCP).
Se ha implementado un controlador, cuya labor es la de hacer de Handler de excepciones propio de modo que el manejo de excepciones sea centralizado por este controlador. Además se han creado excepciones propias de la aplicación.
Por último, por cada ejecución se consume la TracerAPI (Librería externa) que registra los campos de entrada y el resultado de las operaciones.

### Procedimientos de compilación y ejecución
Se debe tener instalado Maven y Java 11 en el equipo.

Deben seguirse en orden los siguientes comandos:

```
git clone https://github.com/carlosvrob/calculadora-api
cd calculadora-api/
mvn validate
mvn verify
mvn clean install
java -jar target/calculator-0.0.1-SNAPSHOT.jar
```
Además, si se desea ejecutar los tests puede usarse el comando `mvn test`.  

Si se han seguido los comandos indicados ya pueden realizarse las llamadas a la API.

Si disponemos de un software como Postman, 
indicamos la URL sobre la que se hace la petición (método HTTP: POST) y construimos el JSON que se usará como Body de entrada de la petición.
Tras pulsar el botón "SEND" se lanza la petición y en la parte inferior de la pantalla se muestra el resultado de la llamada a la API.

### Ejemplos de llamadas de la API

#### Suma
![image](https://user-images.githubusercontent.com/109756222/181236650-0aa71970-7ac4-4ffb-8ba0-28b2ddd7600a.png)

#### Resta
![image](https://user-images.githubusercontent.com/109756222/181237375-a163565e-7d7f-48d3-9d6d-20702d5d7480.png)

#### Multiplicación
![image](https://user-images.githubusercontent.com/109756222/181237472-474642ad-ace1-4b10-9622-fa9b9bacfbdd.png)

#### Error por Operación incorrecta/No implementada:
![image](https://user-images.githubusercontent.com/109756222/181237695-f27bbf91-e0df-4d20-969b-4e9930b5b064.png)  


Además, una vez arrancada la aplicación, puede consultarse toda la información de la API (Especificación OpenAPI 3.0) en la siguiente URL: http://localhost:8080/swagger-ui.html  
![image](https://user-images.githubusercontent.com/109756222/181271388-937aa501-53be-40aa-86ce-548fc41e3823.png)








