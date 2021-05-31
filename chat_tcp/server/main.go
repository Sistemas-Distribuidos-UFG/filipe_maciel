package main

import (
	"log"
	"net"
)

func main() {
	s := newServer()
	go s.run()

	listener, err := net.Listen("tcp", ":8888")
	if err != nil {
		log.Fatalf("Não foi possível iniciar o servidor: %s", err.Error())
	}

	defer listener.Close()
	log.Printf("servidor iniciado na porta : 8888")

	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Printf("Não foi possível aceitar a connexão: %s", err.Error())
			continue
		}

		go s.newClient(conn)
	}
}
