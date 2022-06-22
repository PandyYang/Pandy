● 注意阿里云上安装的，看最下面。先不要启动服务。
下载二进制包：
https://dlcdn.apache.org/rocketmq/4.9.2/rocketmq-all-4.9.2-bin-release.zip
解压之后启动name server
// 启动namesrv
nohup sh bin/mqnamesrv &
// 查看启动日志
tail -f ~/logs/rocketmqlogs/namesrv.log
启动broker
nohup sh bin/mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log
运行测试程序
在收发程序之前，需要告诉客户端name servers的地址，mq提供了多种实现方式，简单点就是使用NAMESRV_ADDR环境变量。
export NAMESRV_ADDR=localhost:9876

sh bin/tools.sh org.apache.rocketmq.example.quickstart.Producer
// 打印的日志
SendResult [sendStatus=SEND_OK, msgId= ...

sh bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
// 打印的日志
ConsumeMessageThread_%d Receive New Messages: [MessageExt...
使用jps命令查看当前java进程

关闭服务
sh bin/mqshutdown broker

sh bin/mqshutdown namesrv

解决阿里云上安装无法通过程序连接的问题
RocketMQ 部署在虚拟机上，内网 ip 为 10.10.30.63，该虚拟机一个 docker0 网卡，ip 为 172.17.0.1。RocketMQ broker 启动时默认使用了 docker0 网卡，生产者客户端无法连接 172.17.0.1，造成以上问题。
● 修改conf文件下的broker.conf
brokerClusterName = DefaultCluster
brokerName = broker-a
brokerId = 0
deleteWhen = 04
fileReservedTime = 48
brokerRole = ASYNC_MASTER
flushDiskType = ASYNC_FLUSH
brokerIP1=127.0.0.1
brokerIP2=127.0.0.1
# 将namesrvAddr设置在configfile中
namesrvAddr=127.0.0.1:9876
● 增加
brokerIP1=127.0.0.1
brokerIP2=127.0.0.1
# 将namesrvAddr设置在configfile中
namesrvAddr=127.0.0.1:9876
● 启动namesrc时指定配置文件
nohup sh bin/mqbroker -n localhost:9876 -c conf/broker.conf &
