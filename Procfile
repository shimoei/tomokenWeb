build: mvn -DskipTests clean dependency:list install -Pheroku
web: java $JAVA_OPTS -jar target/*.jar --server.port=$PORT
