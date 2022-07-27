package effectivego

import "fmt"

func complexType() {
	a := [...]string{}
	s := []string{}
	m := map[int]string{}
	fmt.Println(a, s, m)
}
