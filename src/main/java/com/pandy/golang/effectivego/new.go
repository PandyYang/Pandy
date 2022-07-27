package effectivego

import (
	"bytes"
	"fmt"
	"sync"
)

type SyncedBuffer struct {
	lock   sync.Mutex
	buffer bytes.Buffer
}

func initFunc() {
	p := new(SyncedBuffer) // type *SyncedBuffer
	var v SyncedBuffer     // type SyncedBuffer
	fmt.Println(p, v)
}
