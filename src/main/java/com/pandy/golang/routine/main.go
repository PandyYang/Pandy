package main

import (
	"fmt"
)

func hello() {
	fmt.Println("Hello World!!!")
}
func main() {
	for i := 0; i < 10; i++ {
		go hello()
	}
	fmt.Println("Bye!!!")

	sem := make(chan int, 30)
	for {
		sem <- 1 // will block if there is MAX ints in sem
		go func() {
			fmt.Println("hello again, world")
			<-sem // removes an int from sem, allowing another to proceed
		}()
	}
}
