package main

type color byte

func test(c color) {
	println(c)
}

func main() {
	const (
		x = iota
		y
		z
	)
	println(x, y, z)

	const (
		_  = iota
		KB = 1 << (10 * iota)
		MB
		GB
		TB
	)
	println(KB, MB, GB, TB)

	const (
		a = iota
		b
		c = 100 // 中断iota
		d
		e = iota // 显式回复
		f
	)

	const (
		a2         = iota // int
		b2 float32 = iota // float32
		c2         = iota // int
	)

	const (
		black color = iota
		red
		blue
	)

	test(red)
	test(100)

}
