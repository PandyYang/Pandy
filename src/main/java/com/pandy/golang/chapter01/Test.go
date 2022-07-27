package main

import (
	"errors"
	"fmt"
)

// 函数可以有多个返回值
func div(a, b int) (int, error) {
	if b == 0 {
		return 0, errors.New("division by zero")
	}
	return a / b, nil
}

// 函数是第一类型可以作为参数或者返回值
func test(x int) func() {
	return func() {
		println(x, "-------")
	}
}

// 使用defer延迟调用 无论函数是否出错 都能保证结束前调用
func test2(a, b int) {
	//println(a  / b)
	defer println("dospose...")
}

func main() {

	// 类似于while(x < 5)
	x := 0
	for x < 5 {
		print(x)
		x++
	}

	println()

	x2 := 4
	// 类似于while(true)
	for {
		print(x2)
		x2--
		if x2 < 0 {
			break
		}
	}

	// for range返回元素和索引
	x3 := []int{100, 101, 102}
	for i, n := range x3 {
		println(i, ":", n)
	}

	a, b := 10, 2
	c, err := div(a, b)
	fmt.Println(c, err)

	x4 := 100
	f := test(x4)
	f()

	test2(10, 0)

}
