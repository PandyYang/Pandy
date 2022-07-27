package main

import "fmt"

func main() {
	x := make([]int, 1, 5) // 创建容量为5的切片
	println(len(x))
	for i := 0; i < 8; i++ { // 追加数据 当超出容量限制的时候 自动扩容
		x = append(x, i)
	}
	fmt.Println(x)

	m := make(map[string]int)
	m["a"] = 1
	// ok-idiom模式 在多返回值中用一个名为ok的布尔值 标示操作是否成功
	x2, ok := m["b"]
	fmt.Println(x2, ok)
	delete(m, "a")
	args := m["a"]
	println(args)

}
