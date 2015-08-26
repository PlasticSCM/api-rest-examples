import sys
import requests

__api_url = "http://localhost:9090/api/v1"


def create_repository(name, server):
    url = __api_url + "/repos"
    params = {"name": name,
              "server": server}
    req = requests.post(url, params)
    if req.status_code is not 200:
        print("The repository could not be created", file=sys.stderr)
        exit(-1)


def main():
    name = input("Write a name for the new repository: ")
    server = input("Enter the PlasticSCM server address: ")
    try:
        create_repository(name, server)
    except requests.RequestException as e:
        print(e)
        exit(-1)

if __name__ == "__main__":
    main()