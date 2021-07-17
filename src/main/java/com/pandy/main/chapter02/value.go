package main

func main() {
	var x int
	var y = false
	var x1, y1 int
	var a, s = 100, "abx"
	var (
		x2, y2 int
		a2, s2 = 100, "add"
	)

	// 简短模式
	// 定义变量 同时显式初始化
	// 不能提供数据类型
	// 只能用在函数内部
	x2 = 100
	a4, s3 := 1, "abc"

	println(x, y, x1, y1, a, s, x2, y2, a2, s2, x, x2, a4, s3)

	// 退化赋值的前提条件: 最少有一个新变量被定义
	x5 := 100
	println(&x5)

	//x5 := 200
	//println(&x5, x5)

	x6 := 100
	println(&x6, x6)
	{
		x6, y6 := 222, 333 // 不同作用域 全部是新变量定义
		println(&x6, x6, y6)
	}

	////重复使用err 退化赋值的作用
	//f, err := os.Open("/123")
	//buf := make([]byte, 1024)
	//n, err := f.Read(buf) //err退化复制 n有新含义

	// 多变量赋值
	x7, y7 := 1, 2
	x7, y7 = y7+3, x7+2
	println(x7, y7)
}
