package main

import (
	"fmt"
	"time"
)

func main() {
	var temp int
	for temp = 0; temp < 10; temp++ {

		go func(temp int) {
			fmt.Println(temp)
		}(temp)
	}
	time.Sleep(1 * time.Second)
}
