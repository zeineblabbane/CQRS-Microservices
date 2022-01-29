# MicroServices CQRS Mini Project
To run this project just run the following on the root of the project:
``` console
docker-compose up
```
And then run the SpringBoot project! 

## Possible requests


| Action        | Method           | Request | Body |
| ------------- |:-------------:| ------------------ | ---------- |
| Get all persons     | Get | localhost:8080/persons | None |
| Get a person     | Get | localhost:8080/persons/_{person-id}_ | None |
| Add a person   | Post | localhost:8080/persons | Person object |
| Modify a person   | Put | localhost:8080/persons | Person object |
| Delete a person | Delete | localhost:8080/persons/_{product-ref}_ | None |

A person object follows this format:

``` json
{
    "personId": "str",
    "fname": "str",
    "lname": "str"
}
```

## Happy coding