package effectivego

import "fmt"

func unhex(c byte) byte {
	// 如果switch没有表达式 则对true进行匹配
	switch {
	case '0' <= c && c <= '9':
		return c - '0'
	case 'a' <= c && c <= 'f':
		return c - 'a' + 10
	case 'A' <= c && c <= 'F':
		return c - 'A' + 10
	}
	return 0
}

// switch不会自动从一个case子句跌落到下一个case子句，但是case可以使用逗号分隔的列表
func shouldEscape(c byte) bool {
	switch c {
	case ' ', '?', '&', '=', '#', '+', '%':
		return true
	}
	return false
}

// 终止包含它的循环
func breakLoop(src []int) {
Loop: // 使用标号 可以跳出外层循环
	for n := 0; n < len(src); n += 2 {
		switch {
		case src[n] < 1:
			{
				// do something
			}
		case src[n] < 2:
			// do something
			if 1 > 2 {
				break Loop
			}
		}
	}
}

// 用于获取一个接口变量的动态类型
func typeSwitch() {
	var t interface{}
	t = breakLoop
	// 类型断言的语法 在括号中使用关键字type
	switch t := t.(type) {
	default:
		fmt.Println("unexpected type %T", t)
	case bool:
		fmt.Println("boolean %t\n", t)
	case int:
		fmt.Println("integer %d\n", t)
	case *bool:
		fmt.Println("pointer to boolean %t\n", t)
	case *int:
		fmt.Println("pointer to integer %d\n", *t)
	}
}
