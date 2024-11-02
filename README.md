# Proyecto de Detección de Mutantes

## Descripción
Este proyecto tiene como objetivo detectar si un humano es un mutante basado en su secuencia de ADN. Utiliza un método eficiente para verificar la presencia de secuencias de cuatro letras iguales en una matriz de ADN (6x6).

## Funcionalidad

### Nivel 1: Implementación del Método `isMutant`
- **Función**: La función `isMutant(String[] dna)` determina si la secuencia de ADN corresponde a un mutante.
  
- **Ejemplo de Uso**:
    ```java
    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    boolean result = isMutant(dna);
    System.out.println(result); // Debería imprimir "true"
    ```

### Nivel 2: API REST para Detección de Mutantes
- **Crear la API REST**: La API está diseñada para detectar si un humano es mutante mediante una secuencia de ADN.

- **Hostear la API**: La API está hospedada en un servicio de cloud computing gratuito. [Enlace a la API](https://parcialmagneto-kkq9.onrender.com/swagger-ui/index.html)

- **Endpoints**:
  - **POST** `/mutant`:
    - Formato de la Solicitud:
      ```json
      {
          "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
      }
      ```
    - Respuesta: 
      - **200 OK** si el ADN es de un mutante.
      - **403 Forbidden** si el ADN pertenece a un humano.

### Nivel 3: Integración de Base de Datos y Estadísticas
- **Integración de H2**: Se ha añadido una base de datos H2 para almacenar los ADN verificados, permitiendo solo un registro por ADN.

- **Endpoint de Estadísticas**:
  - **GET** `/stats`: Retorna un JSON con estadísticas de verificaciones de ADN.
    - Formato de Respuesta:
      ```json
      {
          "count_mutant_dna": 40,
          "count_human_dna": 100,
          "ratio": 0.4
      }
      ```

## Requisitos de Escalabilidad
La API está diseñada para manejar fluctuaciones agresivas de tráfico, con un rango estimado de entre 100 y 1 millón de peticiones por segundo.

## Pruebas Automáticas
Se implementaron pruebas automáticas con una cobertura de código superior al **80%**. Los resultados de las pruebas de carga se realizaron con JMeter y están documentados.

## Entrega
- **Código Fuente**: [Enlace al repositorio de GitHub](https://github.com/matiasalmendros/parcialmagneto)
- **Documentación PDF**: [Link pdf](https://github.com/matiasalmendros/parcialmagneto/blob/main/Datos%20extras.pdf)
