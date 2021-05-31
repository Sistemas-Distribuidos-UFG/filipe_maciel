package main

import (
	"fmt"
	"log"
	"net"

	"github.com/ichtrojan/grpc-server/chat"

	"google.golang.org/grpc"
)

func main() {
	port := 9000

	listener, err := net.Listen("tcp", fmt.Sprintf(":%d", port))

	if err != nil {
		log.Fatal(err)
	}

	chatServer := chat.Server{}

	grpcServer := grpc.NewServer()

	chat.RegisterChatServiceServer(grpcServer, &chatServer)

	if err := grpcServer.Serve(listener); err != nil {
		log.Fatal(err)
	}
}
