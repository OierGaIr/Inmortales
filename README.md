**PARA INSTALAR EL PROYECTO**

1. Tener Eclipse, y MySQL, el sql esta para workBech. Pero es hibernate, con que sea una base de datos relacional deberia de ser suficiente.
2. Clonar el proyecto en el workSpace que este en uso.
3. Una vez clonado, en MySQL crearemos una base de datos que vamos a llamar _db_Inmortales_ "create database db_Inmortales;".
4. Una vez creada vamos a establecer la ruta de la base de datos en _/Inmortales/src/main/resources/application.properties_
  spring.application.name=Inmortales
  spring.datasource.url=jdbc:mysql://localhost:3306/db_inmortales
  spring.datasource.username=root
  spring.datasource.password=****
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
5. Una vez establecido los parametros, lanzamos el proyecto, comprobar la tabla en mysql, y probar con PostMan la API
  _/Inmortales/src/main/resources/INMORTALES.postman_collection.json_
