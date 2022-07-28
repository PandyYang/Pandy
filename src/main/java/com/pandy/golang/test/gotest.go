package main

// 函数签名 func（m int） int
func add1() func(int) int {
	var x int
	return func(m int) int {
		x += m
		return m
	}
}

func add2() func(m int) int {
	var x int
	return func(m int) int {
		x += m
		return m
	}
}

func add3() func(m int) int {
	var x int
	return func(m int) int {
		x += m
		return m
	}
}

func main() {
	var s func(int) int = add1()
	print(s(2))
}
