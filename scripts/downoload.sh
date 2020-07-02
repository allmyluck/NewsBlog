#!/bin/bash
wget --limit-rate=100k -P ~/practice/files/ https://lenta.ru/rss/news ; mv ~/practice/files/news ~/practice/files/news_lenta
wget --limit-rate=100k -P ~/practice/files/ https://meduza.io/rss/news ; mv ~/practice/files/news ~/practice/files/news_meduza
