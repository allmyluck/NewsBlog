1)RSS файлы(XML) -> обкачка(защита от сохранения дублей уже обкаченных новостей).
Скачка файлов(RSS потоков с переименованием):
/* 
   1)wget --limit-rate=100k -P ~/practice/files/ https://lenta.ru/rss/news ; mv ~/practice/files/news ~/practice/files/news_lenta
   2)wget --limit-rate=100k -P ~/practice/files/ https://meduza.io/rss/news ; mv ~/practice/files/news ~/practice/files/news_meduza

*/
вызов скрипта:sh /home/nikita/practice/scripts/downoload.sh (cronpad!!!) 
/*
https://lenta.ru/rss/news
https://meduza.io/rss/news
*/
2) Парсинг(XML), сохраняете из разных источников в один формат в БД (видимо столбцы title, description, author, date и т.д.).
3) Пишите приложение на Spring, который подключается к БД и уже отоборажает красиво данные.(Веб- отображение)
----------------------------------------------------------------------------------------------------------------------------------
1) Создал Бд:
"CREATE TABLE authors(id INT NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, PRIMARY KEY(id));";
"CREATE TABLE news(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, idAuthor INT NOT NULL, title TEXT, description TEXT, puDate DATETIME, link TEXT, FOREIGN KEY (idAuthor)  REFERENCES authors(id));";
