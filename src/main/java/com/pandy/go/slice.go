package main

import "fmt"

type person struct {
	name, gender string
}

func f(x *person) {
	(*x).name = "123"
}

func main() {
	var s1 []int    //定义存放int类型元素的切片
	var s2 []string //定义一个存放string类型的切片
	fmt.Println(s1, s2)

	s1 = []int{1, 2, 3}
	s2 = []string{"123", "234"}
	fmt.Println(s1, s2)

	fmt.Printf("len(s1): %d cap(s1): %d\n", len(s1), cap(s1))
	fmt.Printf("len(s2): %d cap(s2): %d\n", len(s2), cap(s2))

	s3 := make([]int, 5, 10)
	fmt.Printf("s1 = %v len(s1)=%d cap(s1) = %d\n", s3, len(s3), cap(s3))

	var p person
	p.name = "1211"
	p.gender = "男"
	fmt.Println(p)
	f(&p)
	fmt.Println(p)

	var p2 = new(person)
	fmt.Printf("%T\n", p2)
}
