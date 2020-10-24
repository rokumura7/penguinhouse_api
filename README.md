# penguinhouse_api

---

## usage

### build
```console
$ docker-compose build
```
You can add `--no-cache` option when you want to run build the image without cache.

### run
```console
$ docker-compose up
```
Now you can use PenguinHouse APIs.  
Access to `http://localhost:9000/api/v1/h`, you will get a response with 200.

### stop
Just press `Ctrl + c`.

---

## test
```console
$ sbt test
```

## MySQL

### Container

```console
$ docker exec -it penguin-mysql bash
# mysql -upenguin -p penguinhouse
```

### From Local

```console
$ mysql -upenguin -p penguinhouse -h127.0.0.1 -P5306
```
