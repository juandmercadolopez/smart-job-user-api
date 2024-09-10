
# Importar el proyecto en un IDE como eclipse o IntelliJ

Despues de que haya sincronizado y descargadas las depedencias solo es darle Run a la clase principal UserAplication.java

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
