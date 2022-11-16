# __Test-task-h2-database setup steps:__

* ```git clone <username>/test-task-h2-database.git ```
* go to the folder ```cd 'your project folder'```
* paste project url from the first step
* open the project in your IDE ```File->Open->'your project folder'```

# __To ```run``` Test-task-h2-database you need:__

__If you have a Linux OS or have a Docker Desktop on your computer:__

* open folder with project in the terminal ```cd 'your project folder'```
* enter ```mvn clean install```
* enter ```docker-compose up -d```

___If you don't have a Linux OS or Docker Desktop on your computer, just run project via your IDE___

# __To ```stop``` Test-task-h2-database you need:__

__If you have a Linux OS or have a Docker Desktop on your computer:__

* open folder with project in the terminal ```cd 'your project folder'```
* enter ```docker-compose down```

___If you don't have a Linux OS or Docker Desktop on your computer, just stop project via your IDE___

# __Steps for work with application:__

__Work with books:__

* For add information about books to the database you should go to ```http://localhost:8083/books/add```
* For get information about books you should go to ```http://localhost:8083/books/all```
* You can update information by ```http://localhost:8083/books/update```
* For delete books from the database you should go to  ```http://localhost:8083/books/delete/<book's id in the db>```
* For search books by title ```http://localhost:8083/books/search-title?title=<title or part of the title>```
* For search books by the author ```http://localhost:8083/books/search-author?author=<author's name or part of the name>```
* For search books by the publisher ```http://localhost:8083/books/search-publisher?publisher=<publisher's name or part of the name>``` 

___Structure of the JSON request to add a book:___ 

```{ "author": "<name>", "title": "<title>", "publisher": "<publisher name>", "publicationDate": "<date format 'yyyy-mm-dd'>"}```

__Work with newspapers:__

* For add information about newspapers to the database you should go to ```http://localhost:8083/newspapers/add```
* For get information about newspapers you should go to ```http://localhost:8083/newspapers/all```
* You can update information by ```http://localhost:8083/newspapers/update```
* For delete newspapers from the database you should go to  ```http://localhost:8083/newspapers/delete/<book's id in the db>```
* For search newspapers by title ```http://localhost:8083/newspapers/search-title?title=<title or part of the title>```
* For search newspapers by the author ```http://localhost:8083/newspapers/search-author?author=<author's name or part of the name>```
* For search newspapers by the publisher ```http://localhost:8083/newspapers/search-publisher?publisher=<publisher's name or part of the name>```

___Structure of the JSON request to add a newspaper:___ 

```{ "author": "<name>", "title": "<title>", "publisher": "<publisher name>", "publicationDate": "<date format 'yyyy-mm-dd'>"}```

__Work with magazines:__

* For add information about magazines to the database you should go to ```http://localhost:8083/magazines/add```
* For get information about magazines you should go to ```http://localhost:8083/magazines/all```
* You can update information by ```http://localhost:8083/magazines/update```
* For delete magazines from the database you should go to  ```http://localhost:8083/magazines/delete/<book's id in the db>```
* For search magazines by title ```http://localhost:8083/magazines/search-title?title=<title or part of the title>```
* For search magazines by the editor ```http://localhost:8083/magazines/search-editor?editor=<editor's name or part of the name>```
* For search magazines by the publisher ```http://localhost:8083/magazines/search-publisher?publisher=<publisher's name or part of the name>```

___Structure of the JSON request to add a magazine:___ 

```{ "editor": "<name>", "title": "<title>", "publisher": "<publisher name>", "publicationDate": "<date format 'yyyy-mm-dd'>"}```