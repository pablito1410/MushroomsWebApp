## Instalacja bazy danych

Pobieramy postgres'a:
* [Postgres](https://www.postgresql.org/download/)

Pobieramy Squirrel'a:
* [Squirrel](http://squirrel-sql.sourceforge.net/#installation)

**UWAGA: Driver postgresa musi by� conajmniej w wersji 9.4.1211**

W folderze bin, gdzie zainstalowali�my postgres'a znajduje si� plik psql.exe.
Wykonujemy w tym folderze nast�puj�ce polecenia:
```bash
psql.exe -U postgres
```
has�o jak dla lokalnego u�ytkownika
```bash
create user admin with superuser password 'admin1';
create database mushrooms;
grant all privileges on database "mushrooms" to admin;
\q
psql.exe -U admin mushrooms
```

Nast�pnie wykonujemy skrypt Mushrooms.dll. Mo�na to zrobi� ju� w Squirrelu.
Instrukcja jak po��czy� si� z baz�:
* [Instrukcja](http://squirrel-sql.sourceforge.net/paper/GettingStartedusingtheSQuirreLSQLClient.pdf)

## Uruchomienie projektu

Zainstalowa� Node.js:
* [Node](https://nodejs.org/en/)

Zainstalowa� Mavena w wersji co najmniej 3.1:
* [Maven](https://maven.apache.org/download.cgi)

Zainstalowa� Angulara CLI:
```bash
npm install -g @angular/cli
```

Projekt kompilujemy i uruchamiamy:
```bash
mvn clean install
cd backend
mvn spring-boot:run
```

## Uruchomienie wy��cznie frontendu

```bash
cd frontend/src/main/frontend
ng serve
```