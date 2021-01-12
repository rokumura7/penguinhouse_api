# penguinhouse_api

## usage

### build
```console
$ docker-compose build
```
You can add `--no-cache` option when you want to run build the image without cache.

### run
```console
$ docker-compose up

・・・

penguin-app_1    | --- (Running the application, auto-reloading is enabled) ---
penguin-app_1    | 
penguin-app_1    | [info] p.c.s.AkkaHttpServer - Listening for HTTP on /0.0.0.0:9000
penguin-app_1    | 
penguin-app_1    | (Server started, use Enter to stop and go back to the console...)
```
This command may take some time.  
If you want to run this process on background, add `-d` option.

#### check connection
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

#### stop
Just press `Ctrl + c`.

If you are running docker on background, use `docker-compose down`.

---

## Scala test
```console
$ sbt test
```

---

## Docker Containers

### MySQL

#### Container

```console
$ docker exec -it penguin-mysql bash
# mysql -upenguin -ppenguin
```

#### From Local

```console
$ mysql -upenguin -ppenguin -h127.0.0.1 -P5306
```

### S3(minio)

go to http://127.0.0.1:9013/ with any browser.
