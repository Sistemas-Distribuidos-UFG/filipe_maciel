package chat

import (
	"fmt"
	"log"

	"golang.org/x/net/context"
)

type Server struct{}

func (s *Server) SayHello(ctx context.Context, message *Message) (*Response, error) {
	log.Println("SayHello Called")
	return &Response{Body: fmt.Sprintf("Nova Mensagem: %s", message.Body)}, nil
}

func (s *Server) GetDetails(ctx context.Context, message *Details) (*Response, error) {
	log.Println("GetDetails Called")
	return &Response{Body: fmt.Sprintf("Seu nome é %s e você possui %d anos de idade", message.Name, message.Age)}, nil
}
