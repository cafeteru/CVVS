# CVVS
Evaluación extraordinaria con motivo de la suspensión de la actividad presencial

## Pasos para ejecutar las pruebas

1. Arrancar la base de datos.
   - Descomprimir el fichero `data.zip`
   - Ejecutar el archivo `startup.bat` en Windows. En Linux o Mac ejecutar en un terminal el comando que esta dentro del fichero.
2. Iniciar la aplicacion de Spring Boot
   - En linea de comando ejecutar el siguiente comando
   ```cmd
   mvn spring-boot:run
   ```
3. Ejecutar las pruebas
   - En linea de comando ejecutar el siguiente comando
     ```cmd
     mvn test
     ```

Para ejecutar este proyecto en un IDE hay que importarlo como un proyecto de Maven
