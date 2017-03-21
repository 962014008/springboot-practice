![](https://img.shields.io/badge/jdk-1.8-green.svg)
![](https://img.shields.io/badge/docker--compose-1.9.0-blue.svg)

## 运行

Run application

#### 1. 使用 `docker`
```
$ docker-compose up --build
```

#### 2. 作为一个 maven 项目
- 导入项目，自动安装依赖
- 运行带 main 方法的主程序

**访问 http://localhost:8080 即可**

## logback 配置
参悟 `logback` 配置，自定义日志文件名、路径、大小等。默认记录到 `/tmp` 目录下。

Logback logs will be found under `/tmp` folder on your host.

## 备注

为了支持spring profile, 配置文件的名称必须为 `logback-spring.xml`


