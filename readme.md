   
## Docker Image Eklenmesi
    PostgreSQL
    userName : postgres
    password: root
    DB : AuthDB


```bash
docker run -d --name postgresql -p 5432:5432 muhammedali55/postgresql:v.0.1
```

```bash
docker run -d --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=AuthDB -p 5433:5432 postgres:16

```

    MongoDB
    userName: admin
    password: root
    DB : UserProfileDB

```bash
docker run -d --name mongodb -p 27017:27017 muhammedali55/mongodb:v.0.3
```
```bash
docker run -d --name mongodb -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=root  -p 27019:27017 mongo:latest
```

    mongod:
    db.createUser({user: "erdem",pwd: "root",roles: ["readWrite","dbAdmin"]}) 
```bash
docker run --name microservice-redis -p 6379:6379 -d redis
docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash

docker run  --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```

