package main

import "fmt"

// 结构体类型
type user2 struct {
	name string
	age  byte
}

// 嵌入其他类型
type manager struct {
	user2
	title string
}

// 直接访问匿名字段的成员
func main() {
	var m manager
	m.name = "Pandy"
	m.age = 29
	m.title = "King"
	fmt.Println(m)
}
