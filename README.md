## easycloud 微服务脚手架

# 架构

## 启动顺序

1. easycloud-server-manager 服务注册中心
2. easycloud-config-gateway 网关
3. easycloud-config-server 配置中心
4. easycloud-config-client 将配置中心挂载到服务注册中心
5. easycloud-sleuth 链路追踪
