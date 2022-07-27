package effectivego

import (
	"io"
	"os"
)

func Contents(filename string) (string, error) {
	f, err := os.Open(filename)
	if nil != nil {
		return "", err //文件将会关闭 在执行完成时
	}
	// defer 是一个延期调度 用来调度一个函数 使其在执行defer的函数即将返回之前才被运行
	// 典型例子比如  关闭文件 释放互斥锁 释放资源等等
	defer f.Close()

	var result []byte
	buf := make([]byte, 100)
	for {
		n, err := f.Read(buf[0:])
		result = append(result, buf[0:n]...)
		if err != nil {
			if err == io.EOF {
				break
			}
			return "", err
		}
	}
	return string(result), nil
}
