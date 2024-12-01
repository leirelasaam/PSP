# Clases
## Servidor
En el servidor se escucha un máximo de 3 clientes por defecto, se puede cambiar estableciendo un nuevo valor de **MAX_CONEXIONES**.

## Cliente
Se deben ir creando nuevos clientes.

# Ejecución
## Compilación por defecto
Se ha compilado con la versión **javac 17.0.13**.

## Ejemplo
Consola con servidor:
```bash
➜  leire@LeireVictus:/PSP/Sockets/src$ java ejercicio2.Servidor
> Servidor iniciado.
> Recibido: Hola servidor, soy un cliente.
> Recibido: Hola servidor, soy un cliente.
> Recibido: Hola servidor, soy un cliente.
> Demasiados clientes por hoy.
```

Consola con clientes:
```bash
➜  leire@LeireVictus:/PSP/Sockets/src$ java ejercicio2.Cliente
> Conexión realizada con el servidor.
> Respuesta del servidor: Saludos desde el servidor al Cliente Nº 1
➜  src git:(main) ✗ java ejercicio2.Cliente
> Conexión realizada con el servidor.
> Respuesta del servidor: Saludos desde el servidor al Cliente Nº 2
➜  src git:(main) ✗ java ejercicio2.Cliente
> Conexión realizada con el servidor.
> Respuesta del servidor: Saludos desde el servidor al Cliente Nº 3
➜  src git:(main) ✗ java ejercicio2.Cliente
> Error en el cliente: Connection refused
```