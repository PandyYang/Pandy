package main

import "fmt"

// 使用map模拟set实现
func main() {

	var urls = []string{"1", "2", "3", "4"}
	var furls = []string{"2", "3", "4", "5"}

	set := make(map[string]bool)

	for _, url := range urls {
		set[url] = true
	}
	for _, fUrl := range furls {
		set[fUrl] = true
	}

	for k := range set {
		fmt.Println(k)
	}

}
