package main

import "fmt"

const x, y int = 123, 0x22
const s = "hello world"
const c = "我"

const (
	i, f = 1, 0.123
	b    = false
)

func main() {

	// 未使用不会引发编译错误
	const y = 1.23

	{
		const x = "abc"
		println(x)
	}

	const (
		x  uint16 = 120
		y2        // 与上一行x类型, 右值相同
		s  = "abc"
		z
	)

	fmt.Printf("%T, %v\n", x, y)
	fmt.Printf("%T, %v\n", z, z)

	// 常量和变量的区别
	var x3 = 0x100
	const y3 = 0x200
	println(&x3, x3)
	//println(&y3, y3) 不同于变量在运行期分配内存 常量在编译器预处理阶段直接展开 作为指令数据使用
}
