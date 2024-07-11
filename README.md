# Implementación de Funcionalidades en Azure

Debido a posibles limitaciones para su implementación local, las funcionalidades solicitadas se han implementado en la nube de Azure.

## Primer Servicio: Búsqueda de Personas

### Acceso al Servicio

Para acceder al primer servicio, se debe ingresar a la siguiente URL:

https://pruebaike.azurewebsites.net/api/PersonFind?


### Nombres Predefinidos

Para verificar la funcionalidad, es necesario ingresar cualquiera de los nombres presentados a continuación. La implementación de una base de datos conlleva un costo adicional, por lo que para las pruebas de funcionalidad es suficiente realizar una comparación dentro de la misma lógica.

![Nombres Predefinidos](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/5bb7e6f9-f407-4106-927c-2bb1781f6de7)

### Evidencias de las Pruebas Realizadas

#### Código 302 - FOUND

![Código 302 - FOUND](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/8ad262bc-7dcc-466d-b2f7-51cf7d8317e9)

#### Código 404 - NOT FOUND

![Código 404 - NOT FOUND](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/32865c6c-b520-4649-8cbd-8f6e90767c82)

## Segundo Servicio: Comprobación de Palíndromos

### Acceso al Servicio

Para acceder al segundo servicio, se debe ingresar a la siguiente URL:

https://pruebaike.azurewebsites.net/api/PalindromeChecker?


### Importante

Es necesario utilizar **Postman** o, en caso de Linux, emplear **CURL** para realizar la petición POST y hacer uso del servicio.

### Evidencia de la Prueba Realizada en Postman

![Evidencia de la Prueba Realizada en Postman](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/112a6274-7c92-471b-8d14-a9f67ea9527c)




