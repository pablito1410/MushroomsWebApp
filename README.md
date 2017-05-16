## Instalacja bazy danych

Pobieramy postgres'a:
* [Postgres](https://www.postgresql.org/download/)

Pobieramy Squirrel'a:
* [Squirrel](http://squirrel-sql.sourceforge.net/#installation)

**UWAGA: Driver postgresa musi byæ conajmniej w wersji 9.4.1211**

W folderze bin, gdzie zainstalowaliœmy postgres'a znajduje siê plik psql.exe.
Wykonujemy w tym folderze nastêpuj¹ce polecenia:
```bash
psql.exe -U postgres
```
has³o jak dla lokalnego u¿ytkownika
```bash
create user admin with superuser password 'admin1';
create database mushrooms;
grant all privileges on database "mushrooms" to admin;
\q
psql.exe -U admin mushrooms
```

Nastêpnie wykonujemy skrypt Mushrooms.dll. Mo¿na to zrobiæ ju¿ w Squirrelu.
Instrukcja jak po³¹czyæ siê z baz¹:
* [Instrukcja](http://squirrel-sql.sourceforge.net/paper/GettingStartedusingtheSQuirreLSQLClient.pdf)

## Uruchomienie projektu

Zainstalowaæ Node.js:
* [Node](https://nodejs.org/en/)

Zainstalowaæ Mavena w wersji co najmniej 3.1:
* [Maven](https://maven.apache.org/download.cgi)

Zainstalowaæ Angulara CLI:
```bash
npm install -g @angular/cli
```

Projekt kompilujemy i uruchamiamy:
```bash
mvn clean install
cd backend
mvn spring-boot:run
```

## Uruchomienie wy³¹cznie frontendu

```bash
cd frontend/src/main/frontend
ng serve
```