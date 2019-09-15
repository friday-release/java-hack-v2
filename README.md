# Friday release team


## Локальный запуск

- Запуск БД
```bash
docker-compose up --detach
```

- Сборка и запуск backend
```bash
./build.sh

java -jar app.jar
```

- Запуск frontend
```bash
cd frontend
npm install
npm start
```

## Сборка и деплой

```bash
./build.sh

docker build -t <image-name> .
docker push <image-name> 
```
