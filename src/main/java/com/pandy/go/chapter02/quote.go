package main

import "fmt"

func mkslice() []int {
	s := make([]int, 0, 10)
	s = append(s, 100)
	return s
}

func mkmap() map[string]int {
	m := make(map[string]int)
	m["a"] = 1
	return m
}

func main() {
	m := mkmap()
	println(m["a"])
	s := mkslice()
	println(s[0])

	// new函数可以为引用类型分配内存 但这是不完整创建
	p2 := new(map[string]int)
	m2 := *p2
	m2["a"] = 1
	fmt.Println(m2)
}
