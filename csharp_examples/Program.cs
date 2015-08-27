using Csharp_examples.Actions;
using Csharp_examples.Models;
using Csharp_examples.Utils;
using System;
using System.Collections.Generic;

namespace Csharp_examples
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(mActions);
            string optionStr = Console.ReadLine();

            int option;
            Int32.TryParse(optionStr, out option);

            switch (option)
            {
                case 1:
                default:
                    ListRepositories();
                    break;
                case 2:
                    CreateRepository();
                    break;
                case 3:
                    RenameRepository();
                    break;
                case 4:
                    DeleteRepository();
                    break;
            }
        }

        static void ListRepositories()
        {
            List<Repository> repositories = ApiUtils.ReadRepositoryList().Result;

            foreach (Repository repo in repositories)
            {
                Console.WriteLine(string.Format(" {0}_{1} {2} {3}",
                    repo.RepId.Id, repo.RepId.ModuleId, repo.Name, repo.Server));
            }
        }

        static void CreateRepository()
        {
            Console.Write("Write a name for the repository: ");
            string name = Console.ReadLine();
            Console.Write("Write the direction of the server: ");
            string server = Console.ReadLine();

            CreateRepository action = new CreateRepository()
            {
                Name = name,
                Server = server
            };

            Repository newRepo = ApiUtils.CreateRepository(action).Result;
            Console.Write(string.Format("Repository {0} successfully created!", newRepo.Name));
        }

        static void RenameRepository()
        {
            ListRepositories();
            Console.Write("Write the name of the repository to rename: ");
            string repository = Console.ReadLine();
            Console.Write(string.Format("Write a new name for {0}: ", repository));
            string newName = Console.ReadLine();

            Rename action = new Rename()
            {
                Name = newName
            };

            Repository renamedRepo = ApiUtils.RenameRepository(repository, action).Result;
            Console.Write(string.Format("Repository {0} successfully renamed to {1}.",
                repository, renamedRepo.Name));
        }

        static void DeleteRepository()
        {
            ListRepositories();
            Console.Write("Write the name of the repository to delete: ");
            string name = Console.ReadLine();

            ApiUtils.DeleteRepository(name).Wait();
            Console.Write(string.Format("Repository {0} successfully deleted!", name));
        }

        static string mActions = @"1 - List repositories (cm lrep)
2 - Create a repository (cm mkrep)
3 - Rename a repository (cm rnrep)
4 - Delete a repository (cm rmrep)

Select an option (1/2/3/4): ";
    }
}
