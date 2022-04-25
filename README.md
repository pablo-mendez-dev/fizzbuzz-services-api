
# FizzBuzz Services

FizzBuzz es un algoritmo que devuelve en formato JSON una lista con las características propias de cada número incluido en el rango entro dos numeros que son pasados por parametros al endpoint.

Por ejemplo una invocacion puede ser: 
/intraway/api/fizzbuzz/MIN/MAX

El endpoint imprime todos los números enteros entre estos MIN y MAX pero con las siguientes condiciones: 

1.- Si el numero es multiplo de 3 -> imprimir “Fizz” 

2.-  Si el numero es multiplo de 5 -> imprimir “Buzz” 

3.- Si es múltiplo de ambos -> imprimir “FizzBuzz” 

EL algoritmo valida que MIN es menor o igual a MAX, y si esto ocurre devuelve un JSON, por ejemplo:

 {
    "timestamp": "1650804512000",
    "code": "270",
    "description": "se encontraron múltiplos de 3 y de 5",
    "list": "8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz"
  }

Si MIN es menor a MAX devuelve un JSON que indica el request incorrecto, por ejemplo:

  {
    "timestamp": "1650721628000",
    "status": 400,
    "error": "Bad Request",
    "exception": "com.intraway.exceptions.badrequest",
    "message": "Los parámetros enviados son incorrectos",
    "path": "/intraway/api/fizzbuzz/80/15"
  }



Ademas el servicio almacena en una base de datos MySQL el resultado obtenido de cada invocacion.
Para poder visualizar estos resultados, se pueden consultar los endpoints siguientes:


Para obtener todos los resultados de request correctos:

intraway/api/fizzbuzz/getAllOkResults

Para obtener todos los resultados de request incorrectos:

intraway/api/fizzbuzz/getAllErrorResult

Requerimientos:

	•	Spring Boot 2.6.7 o mayor
	•	MySQL Server 8

Dependencias:

Existen dependecias de otras librerias las cuales estan definidas en el archivo .pom


Build del proyecto

Es necesario tener:

	•	Java JDK 11
	•	Maven 4.0
	•	Git

Comando Maven para generar el ejecutable:

$ mvn clean install

Comando Maven para ejecutar los Test Unitarios: 

$ mvn clean install -Dtests.skip=false

Al ejcutar el servicio, es posible realizar Tests manuales desde la interfaz de Swagger-UI:

/intraway/swagger-ui/index.html


El sistema utiliza la annotation Lombok @Slf4j, por lo tanto es necesario tener configurado Lombok a nivel del IDE para poder compilar.



