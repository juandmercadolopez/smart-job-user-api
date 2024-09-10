################ API CREACION DE USUSARIOS #################

# Descripcion del proyecto, comentarios y aclaraciones

Este proyecto es una API REST para crear y gestionar usuarios. Desarrollado en el IDE IntelliJ. Usa una arqueictura monolita, no fue necesario montar
arquiecturas como la hexagonal debido a que el codigo esta muy legible y aplicar este tipo de arquitectura no es necesario. Se usaron principios SOLID
para el desarrollo del proyecto. Para codigo limpio se usaron las anotaciones de spring boot para validar y las anotaciones de lombok para
la encapsulacion en los modelos y los constructores de las clases.

Todas las validaciones se hicieron usando las caracteristicas de spring boot y no de forma manual. Se usan validaciones de campos en los modelos de
los requests y el uso de controller advise para capturar estos mensajes de error.

Para la documentacion de Swagger se ha usado la depedencia Springfox, la cual genera la documentacion, aunque no tan legible en el levantamiento de la aplicacion.
La primera libreria genera la documentacion. La segunda le da la estetica. Sin embargo, en este caso, se tomo la generacion de la documentacion y se
uso https://editor.swagger.io/ para generar el archivo swagger.yml. Asi mismo si queremos observar la documentacion de manera estetica podemos remitirnos
a el link y pegar el contenido de swagger.yml en el editor de swagger.

En cuanto a los mensajes de error, segun las indicaciones se debe devolver un json con la propiedad mensaje. En mi caso hago la aclaracion,
que la propiedad la puse como "messsage" para mantener homogeneidad en el codigo y buenas practicas. Asi mismo en el controller advise
se creo una captura de multiples errores, por lo que esa propiedad cuando se retorna, se retonrna como messages, ya que es una lista de varios mensajes.

Por ultimo, en las indicaciones del proyecto se solicita que se cree una validacion para correo electronico y que sea configurable. La expresion regular
en el archivo application.yml indica que arranque en este camino pero al final decidi seguir utilizando las mismas validaciones que se usan del framework
para no reinventar la rueda y cambiar el estilo de codigo o la forma de trabajar. En este caso se uso la anotacion @Email de spring boot para validar
el correo electronico.

########## Pasos para levantar el proyecto ##########

Importar el proyecto en un IDE como eclipse o IntelliJ. Despues de que haya sincronizado y descargadas las depedencias solo es darle Run a la clase principal
UserAplication.java

Uso de endpoints: Todos los endpoints excepto el health check estan protegidos con autenticacion basica

usuario: admin
passowrd: admin

- Crear usuario:

POST http://localhost:8080/user/

json body:

{
        "name": "Juan David",
        "email": "Juan@test.org",
        "password": "123456",
        "phones": [
            {
                "number": "3112229321",
                "cityCode": "00005",
                "countryCode": "057"
            },
            {
                "number": "3114453265",
                "cityCode": "00001",
                "countryCode": "057"
            }
        ],
        "active": true
    }

- Actualizar usuario: A diferencia del end point para crear usuario, aqui se debe enviar la propiedad uuid en el json
para indicar el uuid del usuario que se quiere actualizar

PUT http://localhost:8080/user/

{
    "uuid": "08e6728e-4d06-461c-a85f-49f7c654d6a8",
    "name": "Juan David",
    "email": "Juan@test.org",
    "password": "123456",
    "phones": [
        {
            "number": "3112233321",
            "cityCode": "00005",
            "countryCode": "057"
        },
        {
            "number": "3114453265",
            "cityCode": "00001",
            "countryCode": "057"
        }
    ],
    "active": true
}

- Listar todos los usuarios:

GET http://localhost:8080/user/getAll

- Obtener usuario por uuid:

GET http://localhost:8080/user/{uuid}

Ejemplo: http://localhost:8080/user/08e6728e-4d06-461c-a85f-49f7c654d6a8

- Eliminar usuario:

DELETE http://localhost:8080/user/{uuid}

Ejemplo: http://localhost:8080/user/08e6728e-4d06-461c-a85f-49f7c654d6a8
