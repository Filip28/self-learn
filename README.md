# self-learn


### Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

### Docker

- Build docker image 
```shell
 docker build -t self-learn .
```

- Run docker container (-p => mapping ports from container to outer world; -d => detached mode so docker run in background)
```shell
docker run - p 8080:8080 self-learn -d 
```

- Go into container
```shell
docker exec -it <conatiner_id> bash
```

- Show docker logs
```shell
docker logs <container_id> --follow
```

### Docker Container
- Run docker container to run app locally
```shell
docker-compose -f docker-compose-local.yml up -d
```

- Start only one service from specific file
```shell
docker-compose -f docker-compose.yml up -d postgres
```