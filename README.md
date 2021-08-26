# simbirbank

# Описание
Сервис, представляющий банк.  
Позволяет проверить баланс по лицевому счету, а также снять/внести деньги.  

# Сборка
Сборка проекта осуществляется через Maven.  
Используется база данных PostgreSQL.  
Необходимо создать базу и прописать в application.properties

Порт 8081. 

Тестовые данные для проверки взаимодействия с проектом https://github.com/FattakhovRustem/simbircontrol/:   
INSERT INTO public.account(number, balance)   
	VALUES (101480183, 100000);   

INSERT INTO public.account(number, balance)   
	VALUES (101010, 10000);   
