package main

import "strings"

func main() {

	arr := [1000]int{1, 2, 3}
	for idx := 0; idx < len(arr); idx += 500 {
		end := len(arr)
		if idx+500 < end {
			end = idx + 499
		}
		s := arr[idx:end]
		println(len(s))
	}

	s := "123.321"
	println(len(s))
	ss := s[3:len(s)]
	println(ss)

	var ress = ""
	var res = strings.Split("http://dl.xxxxxx.com/8fa1cfbe-549e-45b6/122312312.3/112323222.0-2（3221223）.xmind", "/")[3:]
	for index, ele := range res {
		if index < len(res) {
			ress = ress + ele + "/"
		}
	}

	s2 := ress[0 : len(ress)-1]
	println(s2)
}

func addself() {
	var count int16
	for i := 0; i < 5; i++ {
		count++
	}
}
