## Problema planteado: 
El proyecto se llamará “LaLiga Tracker” y consistirá en una aplicación Android que 
dará información sobre los equipos de la primera división española de la liga de 
fútbol, LaLiga EA Sports. Dispondrá de las siguientes utilidades: 
- De entrada, mostrará un listado de los equipos de primera división. 
- Al seleccionar uno de los equipos mostrará un listado de los jugadores de dicho equipo. 
- En otra pantalla se mostrará un listado con los equipos de la liga ordenados en base a su valor de mercado de mayor a menor. 
- El listado de los equipos tendrá una funcionalidad para filtrar por los equipos favoritos que seleccione el usuario.
  
Los datos serán recogidos de una API gratuita en la que se encuentra toda la información necesaria para el desarrollo:                                           
https://transfermarkt-api.fly.dev/docs#/ .

## Como se va a resolver:
### Metodología de desarrollo
Para organizar el desarrollo de la aplicación se utilizarán herramientas que nos proporciona GitHub según la siguiente metodología de desarrollo.
- Las tareas se dividirán en tareas más pequeñas, llamadas tickets. Cada ticket representa una funcionalidad o una parte específica del desarrollo, 
donde se documentará el qué y cómo se llevará a cabo la solución de un 
problema.  
- Estos tickets se agruparán en períodos de trabajo o “sprints”, que serán 
ciclos de desarrollo que corresponderán a una semana aproximadamente 
cada uno, en el que se enfocará en completar un conjunto de tickets. La 
cantidad de tickets que se completarán por sprint dependerá de la 
complejidad y el tiempo que requiera realizar estas tareas.

Esta metodología de trabajo ayudará a trabajar de manera ordenada, medir los 
avances y adaptarse al ritmo de desarrollo.

### Herramientas de desarrollo:
El desarrollo de la aplicación se llevará a cabo en Android Studio utilizando el 
lenguaje Kotlin.  
Se llevará a cabo los principios del modelo MVVM (Model-View-ViewModel) y los 
principios de Clean Architecture, llevando la distribución del proyecto en carpetas, 
para garantizar la estructura modular, mantenible y escalable.  
Se utilizará el inyector de dependencias Koin para facilitar la reutilización del 
código. 
Se realizarán las correspondientes pruebas unitarias (Testing) de la capa del 
dominio.  

Para la lógica de negocio:
- Se llevarán a cabo el desarrollo de los modelos pertinentes, los casos de uso 
necesarios y se hará uso del “patrón repository”.

Para la gestión y almacenamiento de datos:
- Se utilizará Room como base de datos local para guardar la información de 
los equipos de la liga y los jugadores. Esto permitirá un acceso rápido y sin 
conexión a los datos.
- Además, se utilizará Firebase Firestore como base de datos en la nube para 
mantener los datos actualizados.
- Para recoger los datos de la API remota se hará uso de Retrofit.

Para la capa de presentación:
- Las pantallas del listado de clubes o la clasificación de goleadores se 
dividirá en diferentes fragmentos.
- Para el listado de jugadores de cada club se creará un fragmento detalle, que 
se visualizará al seleccionar uno de los clubes del fragmento principal.

Desarrollo de las vistas:
- Se llevará a cabo en XML.
- Para seleccionar y navegar entre los fragmentos de listado de clubes y 
clasificación por goles se dispondrán de un menú en la parte inferior de la 
pantalla.
- Para mostrar los clubes filtrados por favoritos se dispondrá de un botón en 
la parte superior de la pantalla, dentro del componente “Toolbar”.
- Se llevará a cabo la gestión de estados de la vista (carga, éxito y error). Para 
ello se hará uso de algunas librerías y recursos utilizados en otros proyectos.
