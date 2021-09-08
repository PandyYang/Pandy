package main

import "fmt"

func main() {

	var a = 20  // 声明实际变量
	var ip *int // 声明指针变量

	ip = &a // 指针变量的存储地址
	fmt.Printf("a 变量的地址是")
}
