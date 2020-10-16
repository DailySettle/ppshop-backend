docker run --name ppshop-mysql 
-e MYSQL_ROOT_PASSWORD=chenxiao2 
-e MYSQL_DATABASE=ppshop 
-e MYSQL_USER=ppshop 
-e MYSQL_PASSWORD=chenxiao -d -p 3306:3306 mysql:8.0
