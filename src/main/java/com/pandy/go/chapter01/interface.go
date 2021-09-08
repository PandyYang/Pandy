package main

import "fmt"

type user3 struct {
	name string
	age  byte
}

// 实现接口的方法 就表示实现了接口 duck type 空接口可以接收任意类型的对象
func (u user3) Print() {
	fmt.Printf("%+v", u)
}

type Printer interface {
	Print()
}

func main() {
	var u user3
	u.name = "Tom"
	u.age = 29
	var p Printer = u
	p.Print()
}
