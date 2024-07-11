En este caso, se implementaron las funcionalidades solicitadas en la nube de Azure debido a posibles limitaciones para su implementación local.

Para acceder al primer servicio, se debe ingresar a la siguiente URL:

https://pruebaike.azurewebsites.net/api/PersonFind?

IMPORTANTE: Para verificar la funcionalidad, es necesario ingresar cualquiera de los nombres presentados a continuación. La implementación de una base de datos conlleva un costo adicional, por lo que para las pruebas de funcionalidad es suficiente realizar una comparación dentro de la misma lógica.

![image](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/5bb7e6f9-f407-4106-927c-2bb1781f6de7)

Evidencias de las pruebas realizadas y los códigos de cada petición:

CODIGO 302 - FOUND
![image](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/8ad262bc-7dcc-466d-b2f7-51cf7d8317e9)


CODIGO 404 - NOT FOUND
![image](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/32865c6c-b520-4649-8cbd-8f6e90767c82)

Para acceder al segundo servicio, se debe ingresar a la siguiente URL:

https://pruebaike.azurewebsites.net/api/PalindromeChecker?

IMPORTANTE: Es necesario utilizar Postman o, en caso de Linux, emplear CURL para realizar la petición POST y hacer uso del servicio.

Se adjunta evidencia de la prueba realizada en Postman:

![image](https://github.com/Isra-Dev27/PruebaIKE-Azure-/assets/146276498/112a6274-7c92-471b-8d14-a9f67ea9527c)









