import requestsimport jsonclass Plastic(object):    def __init__(self, endpoint="http://localhost:9090"):        """        Instantiates a new PlasticSCM API wrapper.        :type endpoint: str        :param endpoint: The endpoint of your API, in format        _http://dir:port_ (default "http://localhost:9090")        """        self.__api_url = endpoint + "/api/v1"        self._repos_url = self.__api_url + "/repos/"        self._wkspaces_url = self.__api_url + "/wkspaces/"        self._branches_url = self._repos_url + "%/branches/"        self._labels_url = self._repos_url + "%/labels/"        self._changesets_url = self._repos_url + "%/changesets/"        self._changesest_br_url = self._repos_url + "%/branches/%/changesets"        self._wkspace_changes_url = self._wkspaces_url + "%/changes/"    def get_all_repos(self):        """        Gets from the API a list of the available repositories, along with        their information.        :rtype: int, json        """        req = requests.get(self._repos_url)        return req.status_code, req.json()    def get_one_repo(self, name):        """        Gets from the API the information concerning a single repository,        specified by name.        :type name: str        :param name: The name of the repository.        :rtype: int, json        """        url = self._repos_url + name        req = requests.get(url)        return req.status_code, req.json()    def create_repo(self, name, server="http://localhost:8087"):        """        Creates a repository.        :type name: str        :param name: The name of the new repository.        :type server: str        :param server: The server in which the repository is to be created            (default "http://localhost:8087")        :rtype: int, json        """        params = {"name": name, "server": server}        req = requests.post(self._repos_url, params)        return req.status_code, req.json()    def rename_repo(self, old_name, new_name):        """        Renames a repository.        :type old_name: str        :param old_name: The name of the repository to be renamed.        :type new_name: str        :param new_name: The new name of the repository.        :rtype: int, json        """        params = {"name": new_name}        url = self._repos_url + old_name        req = requests.put(url, params)        return req.status_code, req.json()    def remove_repo(self, name):        """        Deletes a repository.                :type name: str        :param name: The name of the repository to be deleted.        :rtype: int        """        url = self._repos_url + name        req = requests.delete(url)        return req.status_code    def get_all_wkspaces(self):        """        Gets from the API a list of all the available workspaces,        along with their information.        :rtype: int, json        """        req = requests.get(self._wkspaces_url)        return req.status_code, req.json()    def get_one_wkspace(self, wkspace_name):        """        Gets from the API the information concerning a single workspace.        :type wkspace_name: str        :param wkspace: The name of the workspace.        :rtype: int, json        """        url = self._wkspaces_url + wkspace_name        req = requests.get(url)        return req.status_code, req.json()    def create_wkspace(self, name, path, repository):        """        Creates a new workspace in the machine hosting the API server.        :type name: str        :param name: The name of the new workspace.        :type path: str        :param path: The absolute path of the new workspace.        :type repository: str        :param repository: The repository of the new workspace.        :rtype: int, json        """        params = {"name": name, "path": path, "repository": repository}        req = requests.post(self._wkspaces_url, params)        return req.status_code, req.json()    def rename_wkspace(self, old_name, new_name):        """        renames a workspace in the machine hosting the API server.        :type old_name: str        :param old_name: The name of the repository to be renamed.        :type new_name: str        :param new_name: The new name of the repository.        :rtype: int, json        """        url = self._wkspaces_url + old_name        params = {"name": new_name}        req = requests.patch(url, params)        return req.status_code, req.json()    def remove_wkspace(self, name):        """        Deletes a workspace.        :type name: str        :param name: The name of the workspace to be deleted.        :rtype: int, json        """        url = self._wkspaces_url + name        req = requests.delete(url)        return req.status_code    def get_all_branches(self, repository):        """        Returns the information about all the branches in a repository.        :type repository: str        :param repository: The name of the branches's host repository.        :rtype: int, json        """        url = self._branches_url % repository        req = requests.get(url)        return req.status_code, req.json()    def get_one_branch(self, repository, branch_name):        """        Returns the information about a single branch in a repository.        :type repository: str        :param repository: The repository hosting the desired branch.        :type branch_name: str        :param branch_name: The name of the desired branch.        :rtype: int, json        """        url = (self._branches_url % repository) + branch_name        req = requests.get(url)        return req.status_code, req.json()    def create_branch(self, repository, name, origin_type, origin):        """        Creates a branch.        :type repository: str        :param repository: The name of the host repository of the new branch.        :type name: str        :param name: The name of the new branch. Do NOT use a hierarchical name.        :type: origin_type: OriginType        :param origin_type: The type of the origin of the branch.        :rtype: int, json        """        url = self._branches_url % repository        params = {"name": name, "originType": str(origin_type), "origin": origin}        req = requests.post(url, params)        return req.status_code, req.json()    def rename_branch(self, repository, old_name, new_name):        """        Renames a branch.        :type repository: str        :param repository: The name of the host repository of the branch.        :type old_name: str        :param old_name: The hierarchical name of the branch to be renamed.        :type new_name: str        :param new_name: The new name of the branch. Please have in mind that the                hierarchy name can not be changed.        :rtype: int, json        """        url = (self._branches_url % repository) + old_name        params = {"name": new_name}        req = requests.patch(url, params)        return req.status_code, req.json()    def delete_branch(self, repository, branch_name):        """        Deletes a branch.        :type repository: str        :param repository: The name of the host repository of the branch        :type branch_name: str        :param branch_name: The name of the branch to be deleted.        :rtype: int        """        url = (self._branches_url % repository) + branch_name        req = requests.delete(url)        return req.status_code    def get_all_labels(self, repository):        """        Gets a list of all the labels in a repository along with their        information.        :type repository: string        :param repository: The name of the host repository of the labels        :rtype: int, json        """        url = self._labels_url % repository        req = requests.get(url)        return req.status_code, req.json()    def get_one_label(self, repository, label_name):        """        Gets the information about a single label.        :type repository: string        :param repository: The name of the host repository of the labels.        :type label_name: str        :param label_name: The name of the label.        :rtype: int, json        """        url = (self._labels_url % repository) + label_name        req = requests.get(url)        return req.status_code, req.json()    def create_label(self, repository, label_name):        """        Creates a label in a repository.        :type repository: string        :param repository: The name of the future host repository.        :type label_name: str        :param label_name: The name of the new label.        :rtype: int, json        """        url = self._labels_url % repository        params = {"name": label_name}        req = requests.post(url, params)        return req.status_code, req.json()    def rename_label(self, repository, old_name, new_name):        """        Renames a label.        :type repository: string        :param repository: The name of the host repository of the label.        :type old_name: str        :param old_name: The name of the label to be renamed.        :type new_name: str        :param new_name: The new name of the label.        :rtype: int, json        """        url = (self._labels_url % repository) + old_name        params = {"name": new_name}        req = requests.patch(url, params)        return req.status_code, req.json()    def delete_label(self, repository, label_name):        """        Deletes a label.        :type repository: string        :param repository: The name of the host repository of the label.        :type label_name: str        :param label_name: The name of the label to be deleted.        :rtype: int        """        url = (self._labels_url % repository) + label_name        req = requests.delete(url)        return req.status_code    def get_all_changesets(self, repository):        """        Gets the information about all the changesets in a repository.        :type repository: str        :param repository: The name of the host repository of the changesets.        :rtype: int, json        """        url = self._changesets_url % repository        req = requests.get(url)        return req.status_code, req.json()    def get_changesets_in_branch(self, repository, branch):        """        Gets the information about all the changesets in a given branch.        :type repository: str        :param repository: The name of the host repository of the branch.        :type branch: str        :param branch: The hierarchical name of the host branch.        :rtype: int, json        """        url = self._changesest_br_url % repository, branch        req = requests.get(url)        return req.status_code, req.json()    def get_one_changeset(self, repository, cs_id):        """        Gets the information about a single changeset.        :type repository: string        :param repository: The name of the host repository of the changeset.        :type cs_id: int|string        :param cs_id: The id of the changeset.        :rtype: int, json        """        url = (self._changesets_url % repository) + str(cs_id)        req = requests.get(url)        return req.status_code, req.json()    def get_pending_changes_in_wkspace(self, wkspace, change_types):        """        Gets the pending changes in a workspace.        :type wkspace: string        :param wkspace: The name of the workspace.        :type change_types: List[ChangesType]        :param change_types: A list with the desired change types.        :rtype: int, json        """        types_str = ""        for change_type in change_types:            types_str = str(change_type) + ","        params = {"types": types_str}        url = self._wkspace_changes_url % wkspace        req = requests.get(url, params)        return req.status_code, req.json()    def undo_pending_changes_in_wkspace(self, wkspace, paths):        """        Deletes the pending changes in a wkspace. Paths must be a List[str] of        paths representing files with pending changes to be undone.        :type wkspace: str        :param wkspace: The name of the workspace.        :type paths: List[str]        :param paths: The paths of files with changes to be undone.        :rtype: int        """        url = self._wkspace_changes_url % wkspace        params = {"paths": paths}        req = requests.delete(url, json.dumps(params))        return req.status_code