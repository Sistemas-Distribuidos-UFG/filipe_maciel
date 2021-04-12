import requests
import json


def main():
    url = "http://localhost:4000/jsonrpc"
    nome = input("Digite o nome: ")
    cargo = input("Digite o cargo: ")
    salario = input("Digite o salario: ")

    # Example echo method
    # payload = {
    #     "method": "echo",
    #     "params": ["echome!"],
    #     "jsonrpc": "2.0",
    #     "id": 0,
    # }
    payload = {
        "params": [salario, nome, cargo],
        "method": "add",
        "id": 5
    }
    response = requests.post(url, json=payload).json()
    print(response)
    assert response["result"] == "echome!"
    assert response["jsonrpc"]
    assert response["id"] == 0
    # print(response)
if __name__ == "__main__":
    main()