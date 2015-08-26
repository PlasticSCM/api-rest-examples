import sys
import requests

__api_url = "http://localhost:9090/api/v1"


def print_workspaces(wkspaces):
    line = "Name: {0}, path: {1}"
    for wkspace in wkspaces:
        print(line.format(wkspace["name"],
                          wkspace["path"]))


def get_workspaces():
    url = __api_url + "/wkspaces"
    req = requests.get(url)
    if req.status_code is 200:
        return req.json()
    print("Workspace list could not be retrieved.", file=sys.stderr)
    exit(-1)


def remove_workspace(name):
    url = __api_url + "/wkspaces/" + name
    req = requests.delete(url)
    if req.status_code is not 204:
        print("The workspace could not be deleted.", file=sys.stderr)
        sys.exit(-1)


def main():
    try:
        print_workspaces(get_workspaces())
        name = input("Write the name of the workspace to delete: ")
        remove_workspace(name)
    except requests.RequestException as e:
        print(e, file=sys.stderr)
        exit(-1)


if __name__ == "__main__":
    main()