package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/", handler3)
	log.Fatal(http.ListenAndServe("localhost:8889", nil))
}

func handler3(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "%s %s %s\n", r.Method, r.URL, r.Proto)
	for k, v := range r.Header {
		fmt.Fprintf(w, "header[%q] is %q\n", k, v)
	}
	fmt.Fprintf(w, "Host is [%q]\n", r.Host)
	fmt.Fprintf(w, "RomoteAddr is [%q]\n", r.RemoteAddr)

	if error := r.ParseForm(); error != nil {
		log.Print(error)
	}

	for k, v := range r.Form {
		fmt.Fprintf(w, "form[%q]  is %q\n", k, v)
	}

}
