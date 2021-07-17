package main

import (
	"fmt"
	"time"
)

func task(id int) {
	for i := 0; i < 5; i++ {
		fmt.Printf("%d: %d\n", id, i)
		time.Sleep(time.Second)
	}
}

// 消费者
func consumer(data chan int, done chan bool) {
	for x := range data { // 接收数据直到通道被关闭
		println("recv:", x)
	}
	done <- true // 通知main. 消费结束
}

// 生产者
func producer(data chan int) {
	for i := 0; i < 4; i++ {
		data <- i // 发送数据
	}
	close(data) // 生产结束 关闭通道
}

func main() {
	go task(1)
	go task(2)

	time.Sleep(time.Second * 6)

	done := make(chan bool) // 接收消费结束信号
	data := make(chan int)  // 数据通道

	go consumer(data, done) //启动消费者
	go producer(data)       //启动生产者
	<-done                  //阻塞 直到消费者发回结束信号
}
