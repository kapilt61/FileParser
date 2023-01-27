## Create executable jar

Use maven command

```bash
mvn clean install
```
Executable Jar will be created inside target directory

## Execute jar 

```bash
java -jar target/unlimintTask-0.0.1-SNAPSHOT.jar test.csv test.json 
```