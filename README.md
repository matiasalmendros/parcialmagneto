# Proyecto de Detección de Mutantes

## Descripción
Este proyecto permite detectar si un humano es un mutante basándose en su secuencia de ADN. Utiliza un método eficiente que verifica la presencia de secuencias de cuatro letras iguales en una matriz de ADN.

## Nivel 1: Implementación del Método `isMutant`

1. **Función**:
   - La función `isMutant(String[] dna)` determina si la secuencia de ADN corresponde a un mutante.

2. **Ejemplo de Uso**:
   ```java
   String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
   boolean result = isMutant(dna);
   System.out.println(result); // Debería imprimir "true"
   ```

## Nivel 2: API REST para Detección de Mutantes

1. **Crear la API REST**:
   - La API está diseñada para detectar si un humano es mutante mediante una secuencia de ADN.

2. **Hostear la API**:
   - La API se encuentra hospedada en un servicio de cloud computing gratuito. [Enlace a la API](http://localhost:8080/swagger-ui/index.html)

3. **Endpoint del Servicio**:
   - El servicio para verificar si un humano es mutante se puede acceder en el siguiente endpoint:
     ```
     POST /mutant/
     ```

4. **Formato de la Solicitud**:
   - La solicitud debe enviarse en formato JSON con el siguiente formato:
     ```json
     {
       "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
     }
     ```

5. **Respuestas**:
   - Si el ADN es de un mutante, se devuelve un código HTTP **200 OK**.
   - Si el ADN pertenece a un humano, se devuelve un código HTTP **403 Forbidden**.

---

## Nivel 3: Integración de Base de Datos y Estadísticas

1. **Integración de H2**:
   - Se ha anexado una base de datos H2 para almacenar los ADN verificados.
   - Solo se permite un registro por ADN.

2. **Endpoint de Estadísticas**:
   - Un servicio adicional para exponer estadísticas de verificaciones de ADN:
     ```
     GET /stats
     ```

3. **Formato de Respuesta de Estadísticas**:
   - La respuesta devuelve un JSON con el siguiente formato:
     ```json
     {
       "count_mutant_dna": 40,
       "count_human_dna": 100,
       "ratio": 0.4
     }
     ```

4. **Requisitos de Escalabilidad**:
   - La API está diseñada para manejar fluctuaciones agresivas de tráfico, con un rango estimado de entre 100 y 1 millón de peticiones por segundo.

5. **Pruebas Automáticas**:
   - Se implementaron pruebas automáticas con una cobertura de código superior al **80%**.

---

## Resultados de Pruebas

- **Resultados de JMeter**:
  - Los resultados obtenidos de las pruebas de carga con JMeter se encuentran en el documento PDF adjunto.

- **Resultados de JaCoCo**:
  - Los resultados de las pruebas automáticas y la cobertura de código con JaCoCo se encuentran en el documento PDF adjunto.

## Entrega
- Código Fuente: [Enlace al repositorio de GitHub](https://github.com/matiasalmendros/parcialmagneto)
- Instrucciones de ejecución: Consultar el archivo README.md en el repositorio.
- Documentación PDF: [Descargar aquí](URL_DEL_DOCUMENTO_PDF)
