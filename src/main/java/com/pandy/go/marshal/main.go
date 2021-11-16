package main

import (
	"encoding/json"
	"fmt"
)

type CdnRefreshPreheat struct {
	Status      string
	Urls        string
	TaskID      string
	OperateType string
}

func main() {
	res := CdnRefreshPreheat{Status: "failed", Urls: "123.txt,456.txt",
		TaskID: "202111101", OperateType: "refresh"}
	sss, err := json.Marshal(res)
	if err != nil {
		return
	}
	fmt.Println(string(sss))
}
