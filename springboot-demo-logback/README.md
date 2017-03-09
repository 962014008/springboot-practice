![](https://img.shields.io/badge/jdk-1.8-green.svg)
![](https://img.shields.io/badge/docker--compose-1.9.0-blue.svg)

## 运行

Run application

```
$ docker-compose up --build
```

Logback logs will be found under `/tmp` folder on your host.

## 备注

为了支持spring profile, 配置文件的名称必须为 `logback-spring.xml`
