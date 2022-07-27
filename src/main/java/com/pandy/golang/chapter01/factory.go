package main

import "fmt"

type X int

// 名称前的参数称作 receiver
func (x *X) inc() {
	*x++
}

type user struct {
	name string
	age  byte
}

func (u user) Tostring() string {
	return fmt.Sprintf("%+v", u)
}

type manager2 struct {
	user
	title string
}

func main() {
	var x X
	x.inc()
	println(x)

	var m manager2
	m.name = "dida"
	m.age = 24
	println(m.Tostring())
}
