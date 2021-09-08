package main

import "fmt"

type flags byte

const (
	read flags = 1 << iota
	write
	exec
)

func main() {

	type ( // 组
		user struct { //结构体
			name string
			age  uint8
		}
		event func(string) bool //函数类型
	)

	u := user{"Pandy", 20}
	fmt.Println(u)

	var f2 event = func(s string) bool {
		println(s)
		return s != ""
	}

	f2("abc")

	f := read | exec
	fmt.Printf("%b\n", f)

	// 必须显式进行强制类型转换
	//x := 100
	//var b bool = x
}
