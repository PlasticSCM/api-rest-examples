import sys
import requests

__api_url = "http://localhost:9090/api/v1"


def print_repositories(repositories):
    line = "{0} {1} {2}"
    for repo in repositories:
        print(line.format(repo["repId"]["id"],
                          repo["name"],
                          repo["server"]))


def get_repositories():
    url = __api_url + "/repos"
    req = requests.get(url)
    if req.status_code is 200:
        return req.json()
    print("The repository list could not be retrieved.", file=sys.stderr)
    exit(-1)


def create_workspace(name, path, repository):
    url = __api_url + "/wkspaces"
    params = {"name": name,
              "path": path,
              "repository": repository}
    req = requests.post(url, params)
    if req.status_code is not 200:
        print("The workspace could not be created.", file=sys.stderr)
        exit(-1)


def main():
    try:
        print_repositories(get_repositories())
        repository = input("Write the name of a repository to create a new workspace to: ")
        name = input("Write the name for the new workspace: ")
        path = input("Write the path for the new workspace: ")
        create_workspace(name, path, repository)
    except requests.RequestException as e:
        print(e, file=sys.stderr)
        exit(-1)


if __name__ == "__main__":
    main()