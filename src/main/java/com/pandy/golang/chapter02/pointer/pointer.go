package main

import "fmt"

func main() {
	x := 1
	p := &x         // p是整型指针 指向x
	fmt.Println(*p) // 1
	*p = 2          // x = 2
	fmt.Println(x)  // 2
	fmt.Println(p)  // 内存地址 0x1400001c080

	v := 1
	incr(&v)
	fmt.Println(incr(&v))

}

func incr(p *int) int {
	*p++ // 递增p所指向的值 p自身保持不变
	return *p
}
