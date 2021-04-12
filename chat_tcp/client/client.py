import requests
import json


def main():
    url = "http://localhost:8888"
    # nome = input("Digite o nome: ")
    # cargo = input("Digite o cargo: ")
    # salario = input("Digite o salario: ")

    payload = {
        # "params": [salario, nome, cargo],
        "params": [""],
        "method": "add",
        "id": "val"
    }
    response = requests.post(url, json=payload).json()
    # print(response)
    # assert response["result"] == "echome!"
    # assert response["jsonrpc"]
    # assert response["id"] == 0
    # print(response)


if __name__ == "__main__":
    main()
