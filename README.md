# 使用 Docker run postgresql container
要使用 Docker 啟動 PostgreSQL 容器，您可以使用以下指令：
```
docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=12345678 -e POSTGRES_DB=librarymanagement -p 5432:5432 -d postgres
```
指令解釋：
--name postgres：將容器命名為 "postgres"。
-e POSTGRES_USER=admin：指定 PostgreSQL 使用者名稱為 "admin"。
-e POSTGRES_PASSWORD=12345678：指定 PostgreSQL 密碼為 "12345678"。
-e POSTGRES_DB=librarymanagement：指定預設資料庫的名稱為 "librarymanagement"。
-p 5432:5432：將主機的埠口 5432 對應到容器的埠口 5432（PostgreSQL 的預設埠口）。
-d postgres：使用官方的 PostgreSQL 映像在背景中執行容器。

# 可使用 pgadmin4 管理資料庫

# application.properties 設定資料庫連線
確保您的 application.properties 檔案包含正確的設定以連線到 PostgreSQL 資料庫：
```
spring.datasource.url=jdbc:postgresql://localhost:5432/librarymanagement
spring.datasource.username=admin
spring.datasource.password=12345678
```

# 使用 Postman 測試 API