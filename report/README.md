Скачка файлов(RSS потоков с переименованием):

   1)wget --limit-rate=100k -P ~/practice/files/ https://lenta.ru/rss/news ; mv ~/practice/files/news ~/practice/files/news_lenta

   
2)wget --limit-rate=100k -P ~/practice/files/ https://meduza.io/rss/news ; mv ~/practice/files/news ~/practice/files/news_meduza

вызов скрипта:sh /home/nikita/practice/scripts/downoload.sh

/*
https://lenta.ru/rss/news

https://www.belta.by/rss/news

https://meduza.io/rss/news
*/


simple: 

CREATE DATABASE NewsSimpleFormat;

"CREATE TABLE news( author varchar(255) NOT NULL, title TEXT, description TEXT, pubDate varchar(255) NOT NULL, link TEXT, time  BIGINT UNSIGNED NOT NULL);";


//настройка кодировки

sudo nano /etc/mysql/conf.d/utf8_set.cnf

[mysqld]

character-set-server=utf8

collation-server=utf8_general_ci


strong:
"CREATE TABLE authors(id INT NOT NULL AUTO_INCREMENT, name  NOT NULL, PRIMARY KEY(id));";
"CREATE TABLE news(Author INT NOT NULL, title TEXT, description TEXT, pubDate varchar(255) NOT NULL, link TEXT,time  BIGINT UNSIGNED NOT NULL, FOREIGN KEY (idAuthor)  REFERENCES authors(id));";

