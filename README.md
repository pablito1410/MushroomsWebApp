Sprawdź aplikację tutaj: https://mushrooms-picking.herokuapp.com



## Instalacja bazy danych

Pobieramy postgresa:
* [Postgres](https://www.postgresql.org/download/)

Pobieramy driver:
* [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql/9.4.1211)

Pobieramy Squirrela:
* [Squirrel](http://squirrel-sql.sourceforge.net/#installation)

W folderze `bin`, gdzie zainstalowaliśmy postgresa znajduje się plik `psql.exe`.
Wykonujemy w tym folderze z konsoli następujące polecenia:
```bash
psql.exe -U postgres
```
Zostaniemy poproszeni o podanie hasła. Jest ono identyczne jak dla lokalnego użytkownika w systemie. Kolejno wykonujemy:
```bash
create user admin with superuser password 'admin1';
create database mushrooms;
grant all privileges on database "mushrooms" to admin;
\q
psql.exe -U admin mushrooms
```
W tym momencie możemy zarządzać bazą danych z konsoli. Wygodniej jednak będzie skorzystać z dedykowanego środowiska, np. Squirrela.

* Uruchamiamy plik `squirrel-sql.bat` z lokalizacji gdzie wcześniej pobraliśmy Squirrela. 
* Klikamy z lewej strony zakładkę `Drivers`
* Z listy wyszukujemy `PostgreSQL` i klikamy 2 razy
* W zakładce `Extra Class Path` klikamy przycisk `Add` i znajdujemy plik `.jar` z PostgreSQL JDBC Driver, który pobraliśmy wcześniej
* Klikamy `OK`
* Przechodzimy do zakładki `Aliases`
* Klikamy `+`, aby utworzyć nowy alias
* Wpisujemy następujące dane:
```bash
Name: Mushrooms
Driver: // Wybieramy z listy PostgreSQL
URL: jdbc:postgresql://localhost:5432/mushrooms
Username: admin
Password: admin1
```

* Klikamy `Test`, aby sprawdzić połączenie, następnie klikamy `OK`
* Klikamy 2 razy na nowo utworzonym aliasie, następnie `Connect`
* W zakładce "SQL" wklejamy zawartość pliku `Creates.sql` z katalogu `backend/db`, następnie klikamy `CTRL+Enter`
* Po wykonaniu skryptu, w zakładce `Objects` w `Mushrooms/public/Table` powinny znajdować się tabele
* Można również wykonać skrypt `Inserts.sql`, który zawiera przykładowe dane. Wymagane jest rozszerzenie `pgcrypto`, które powinno być domyślnie zainstalowane z pgsql

Szczegółowa instrukcja jak połączyć się z bazą przy użyciu programu Squirrel:
* [Instrukcja](http://squirrel-sql.sourceforge.net/paper/GettingStartedusingtheSQuirreLSQLClient.pdf)

## Uruchomienie projektu

Zainstalować Node.js:
* [Node](https://nodejs.org/en/)

Zainstalować Mavena w wersji co najmniej 3.1:
* [Maven](https://maven.apache.org/download.cgi)

Zainstalować Angular Command Line Interpreter:
```bash
npm install -g @angular/cli
```

Projekt kompilujemy i uruchamiamy:
```bash
mvn clean install
cd backend
mvn spring-boot:run
```

## Uruchomienie wyłącznie frontendu

```bash
cd frontend/src/main/frontend
ng serve
```

## Kontakt

W razie problemów prosimy kontaktować się niezwłocznie:

* **Mateusz Chudy**   matechu268@student.polsl.pl

* **Paweł Krosny**    pawekro700@student.polsl.pl
