package main

import (
	"fmt"
	"time"
)

func main() {
	var count uint16

	go func() {
		for {
			//fmt.Println(count)
			count = count + 1
			//fmt.Println(count)
			//if count == 10 {
			//	break
			//}
			//time.Sleep(time.Second)
			//count = count + 1
		}
	}()

	time.Sleep(time.Second)
	fmt.Println(count)
	fmt.Println("------------------------")
	//fmt.Println(count)
	//fmt.Println(count)
}

func addself() {
	var count int16
	for i := 0; i < 5; i++ {
		count++
	}
}
