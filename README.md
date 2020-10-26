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

```consle
$ curl -I localhost:9009/api/v1/h
HTTP/1.1 200 OK
Referrer-Policy: origin-when-cross-origin, strict-origin-when-cross-origin
X-Frame-Options: DENY
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
X-Permitted-Cross-Domain-Policies: master-only
Date: Sat, 24 Oct 2020 05:13:26 GMT
Content-Length: 0
```

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
