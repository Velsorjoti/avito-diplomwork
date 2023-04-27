Материалы для выполнения курсовой работы учениками профессии java-разработчик.

<div>

## Работа по диплому "Авито" кураса "Java-разработчик ISA" от Skypro
</div>

___
## Описание проекта и его функциональные задачи

Сайт представляет из себя заготовку похожую на интернет-сервис онлайн-покупок Avito.
Пользователи могут размещать объявления и оставлять комментарии к своим объявлениям и объявлением  других пользователей.

### Реализованы следующие функции:

- Авторизация и аутентификация пользователей;
- CRUD-операции для объявлений комментариев к ним  на сайте;
- Пользователи могут выполнять все CRUD-операции со  своими собственными объявлениями и комментариями;
- Администраторы могут удалять или редактировать все объявления и комментарии;
- Поиск объявлений по названию в шапке сайта;
- Загрузка и отображение изображений объявлений и картинок пользователей.

## Задание:
- [Technical task](https://skyengpublic.notion.site/02df5c2390684e3da20c7a696f5d463d)

___
## Инструменты, используемые в проекте:
* Backend:
  - Java 11
  - GIT
  - Spring Boot
  - Maven
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Lombok
  - REST
  - Swagger
  - Stream API
* SQL:
  - PostgreSQL
  - Liquibase
* Frontend:
  - Docker image

___
## Запуск приложения
* Для запуска приложения Вам потребуется выполнить несколько шагов:
  - Клонировать проекта в среду разработки (например, **IntelliJ IDEA** или **VSCode**);
  - В файле **application.properties** указать путь к Вашей базе данных;
  - Запустить **Docker**;
  - В командной строке прописать ```docker pull ghcr.io/bizinmitya/front-react-avito:latest``` и скачать образ;
  - Запустить **Docker image** с помощью команды ```docker run -p 3000:3000 ghcr.io/bizinmitya/front-react-avito:latest```;
  - Запустить метод **main** в файле **MarketplaceApplication.java**.

После выполнения всех шагов веб-сайт будет доступен по адресу: http://localhost:3000

___
### Разработчик:
- [Вадим Дворкин](https://github.com/Velsorjoti)