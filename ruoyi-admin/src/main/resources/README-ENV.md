# 环境配置说明

## 概述

本项目支持多环境配置，包括开发环境（dev）和生产环境（prod）。

## 配置文件结构

```
ruoyi-admin/src/main/resources/
├── application.yml          # 主配置文件
├── application-dev.yml      # 开发环境配置
├── application-prod.yml     # 生产环境配置
├── application-druid.yml    # 数据源配置（已集成到各环境配置中）
└── README-ENV.md           # 本说明文档
```

## 环境切换

### 1. 通过配置文件切换

在 `application.yml` 中修改 `spring.profiles.active` 的值：

```yaml
spring:
  profiles:
    active: dev    # 开发环境
    # active: prod  # 生产环境
```

### 2. 通过启动参数切换

```bash
# 开发环境
mvn spring-boot:run -pl ruoyi-admin -Dspring-boot.run.profiles=dev

# 生产环境
mvn spring-boot:run -pl ruoyi-admin -Dspring-boot.run.profiles=prod
```

### 3. 通过环境变量切换

```bash
# 开发环境
export SPRING_PROFILES_ACTIVE=dev
mvn spring-boot:run -pl ruoyi-admin

# 生产环境
export SPRING_PROFILES_ACTIVE=prod
mvn spring-boot:run -pl ruoyi-admin
```

## 环境配置差异

### 开发环境（dev）

- **日志级别**：DEBUG，详细日志输出
- **热部署**：启用
- **Swagger**：启用
- **Druid监控**：启用
- **文件上传大小**：10MB
- **连接池配置**：较小，适合开发
- **文件路径**：本地路径 `/Users/eric.liang/ruoyi/uploadPath`

### 生产环境（prod）

- **日志级别**：INFO/WARN，精简日志输出
- **热部署**：禁用
- **Swagger**：禁用
- **Druid监控**：禁用
- **文件上传大小**：50MB
- **连接池配置**：较大，适合生产
- **文件路径**：服务器路径 `/opt/ruoyi/uploadPath`
- **Token密钥**：更复杂的密钥
- **密码错误次数**：3次（开发环境5次）
- **密码锁定时间**：30分钟（开发环境10分钟）

## 数据库配置

### 开发环境
- **数据库**：localhost:3306/ry-vue
- **用户名**：root
- **密码**：123456
- **连接池**：初始5个，最小10个，最大20个

### 生产环境
- **数据库**：localhost:3306/ry-vue
- **用户名**：root
- **密码**：123456
- **连接池**：初始10个，最小20个，最大100个

## Redis配置

### 开发环境
- **地址**：localhost:6379
- **密码**：123456
- **连接池**：最大8个连接

### 生产环境
- **地址**：localhost:6379
- **密码**：123456
- **连接池**：最大50个连接

## 注意事项

1. **生产环境部署前**：
   - 修改数据库连接信息
   - 修改Redis连接信息
   - 修改文件上传路径
   - 修改Token密钥

2. **安全配置**：
   - 生产环境已禁用Swagger和Druid监控
   - 生产环境使用更复杂的Token密钥
   - 生产环境启用IP地址获取

3. **性能配置**：
   - 生产环境使用更大的连接池
   - 生产环境使用更大的文件上传限制
   - 生产环境使用更严格的密码策略

## 自定义配置

如需添加新的环境配置，请：

1. 创建 `application-{env}.yml` 文件
2. 在 `application.yml` 中添加对应的profile配置
3. 更新本说明文档

## 启动示例

```bash
# 开发环境启动
mvn spring-boot:run -pl ruoyi-admin -Dspring-boot.run.profiles=dev

# 生产环境启动
mvn spring-boot:run -pl ruoyi-admin -Dspring-boot.run.profiles=prod

# 指定端口启动（开发环境）
mvn spring-boot:run -pl ruoyi-admin -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Dserver.port=8081"
``` 