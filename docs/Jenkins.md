# Documentacion Jenkins

## Instalacion

  Para el proceso de instalación que se va a describir es necesario descargar la última versión LTS del [instalador](https://www.jenkins.io/download/) de Jenkins.

  Una vez descargado seguimos los pasos del instalador brevemente comentados a continuacion.
  1. Elegir la carpeta de destino.
  2. Service Logon Credentials. En este paso se ofrecen dos opciones: *Run as LocalSystem*, *Run service as local or domain user*. Si se desconocen las escoga la primera opción.
  3. Seleción de puerto. Asegurese de no estar corriendo ningun servicio en el puerto selecionado antes de testear.
  4. Seleción del path al jdk. El jdk debera ser de la versión 8 o 11.
  5. Selecionar features.
  6. Aceptar e instalar.

### Post-instalation
  
  Una vez terminado accede a http://localhost:8080 y espera por la página *Unlock Jenkins*. Este pedira una contraseña que puedes encontrar o bien en la ruta indicada dentro de la propia página o en el archivo *jenkins.err.log* del directorio donde se instalo jenkins.

  Una vez introducida la contraseña entraras en la pagina *Customize Jenkins*, la cual ofrece dos opciones instalar *Install suggested plugins*, *Select plugins to install*. Selecione la primera.

  Para terminar Jenkins pedira que crees un usuario adminitrador, introduce el nombre y contraseña deseados y terminaras el proceso de instalación.

### Anotación

  El proceso descrito en el apartado de instalación es un resumen de la [documentación](https://www.jenkins.io/doc/book/installing/windows/) oficial de Jenkins.

## Configuración

  Lo primero de todo será configurar la herramienta para que localice las rutas de instalación de los distintos componentes. Para ello accede primero a la opción de menú: Manage Jenkins -> Global Tool Configuration.

### Java

  En la sección JDK debes indicar la ruta donde tienes instalada la versión de Java que utilizarás. Haz click sobre el botón “Add JDK” e introduce la información requerida.

  ![jdk](imgs/addJDK.PNG?raw=true)

### Maven

  En la sección Maven, vamos a hacer uso de la opción instalar automaticamente. Haz click sobre el botón “Add Maven”, posteriormente sobre el check "Install automatically" y seleciona la versión que desees.

  ![maven](imgs/addMaven.PNG?raw=true)

### Plugins

  Para instalar plugins accede a la opción de menú: Manage Jenkins -> Manage plugins. Busca y seleciona los plugins que necesites en la pestaña *available* y clicka en el boton inferior "Install without restart".

  Serán necesarios dos plugins:
  1. [Maven integration plugin](https://plugins.jenkins.io/maven-plugin/).
  ![mavenPlugin](imgs/mavenPlugin.PNG?raw=true)
  2. [GIT Plugin](https://plugins.jenkins.io/git/). Si en la post-instalación escogiste *Install suggested plugins* este plugin ya deberia estar instalado.
  ![gitPlugin](imgs/gitPlugin.PNG?raw=true)

## Ejecución de Jobs

  En este apartado veremos como configurar y ejecutar jobs.

### Credenciales

  Primero es necesario dar permisos a Jenkins para acceder a nuestro repositorio Git, para lo que necesitas configurar unas credenciales de acceso. Para ello accede a la opción de menú: Manage Jenkins -> Manage credentials.

  Verás una tabla donde puedes crear distintos dominios de credenciales.Clicka sobre el dominio existente “Global credentials”.

  Crea una nueva credencial de tipo *Username with password* con el usuario y contraseñas de git.

  ![credentials](imgs/credentials.PNG?raw=true)

### New Item

  Para crear un nuevo Job selecciona la opción de menú *New Item*. De entre las opciones salientes elige *Maven project*.

#### Descripción

  Escribe una descripción del proyecto y seleciona el repositorio git.

  ![general](imgs/general.PNG?raw=true)

#### Origen de código fuente
 
  Seleciona la opción git e indica el repositorio , la rama y las credenciales ( Las anteriormente creadas).

  ![fontCode](imgs/fontCode.PNG?raw=true)

#### Disparadores
  
  Aquí vamos a establecer que el job se lance cada vez que se produzca un cambio en el repositorio Git. Además, vamos a realizar un Polling contra el respositorio, realizando consultas periódicas cada 10 minutos para detectar si ha producido algún cambio en el código fuente de nuestra aplicación.

  ![Triggers](imgs/triggers.PNG?raw=true)

#### Construcción(Build)

   Indicaremos a Jenkins como realizar la construcción de nuestra aplicación. Dado que estamos construyendo un proyecto Maven, es necesario indicar la ubicación del fichero pom.xml y las fases que queremos ejecutar, que serán clean install.

  ![Build](imgs/build.PNG?raw=true)

#### Finalizar y ejecutar

  Para terminar clicka el botón "Save". 
  
  Para ejecutarlo, bien puedes esperar el intervalo de tiempo que configuramos previamente (10 minutos) o bien puedes lanzarlo manualmente desde la opción de menú “Construir ahora”.

## Notas
  
  Existe un plugin de integración con sonarQube. Con el, en la configuración del proyecto puedes indicar a Jenkins que analice el código fuente una vez realizada la build.