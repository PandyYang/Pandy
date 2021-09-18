package main

import "fmt"

func main() {

	var a = 20 // 声明实际变量
	var _ *int // 声明指针变量

	_ = &a // 指针变量的存储地址
	fmt.Printf("a 变量的地址是")
}
