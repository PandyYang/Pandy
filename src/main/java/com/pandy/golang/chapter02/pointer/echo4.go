package main

import (
	"flag"
	"fmt"
	"strings"
)

// 忽略正常输出时 结尾的换行符
var n = flag.Bool("n", false, "omit trailing newline")

// -s sep 使用sep替换默认参数输出时使用的空格分隔符
var sep = flag.String("s", " ", "separator")

func main() {
	flag.Parse()
	fmt.Print(strings.Join(flag.Args(), *sep))
	if !*n {
		fmt.Println()
	}
}
