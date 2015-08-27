using Csharp_examples.Actions;
using Csharp_examples.Models;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace Csharp_examples.Utils
{
    public class ApiUtils
    {
        static HttpClient GetHttpClient()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9090/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));

            return client;
        }

        public static async Task<List<Repository>> ReadRepositoryList()
        {
            HttpClient client = GetHttpClient();
            using (client)
            {
                HttpResponseMessage response = await client.GetAsync("api/v1/repos");

                if (response.StatusCode != System.Net.HttpStatusCode.OK)
                    throw new Exception(string.Format(
                        "API Status Code {0}. Expected OK.", response.StatusCode));

                return await response.Content.ReadAsAsync<List<Repository>>();
            }
        }

        public static async Task<Repository> CreateRepository(CreateRepository createParams)
        {
            HttpClient client = GetHttpClient();
            using (client)
            {
                HttpResponseMessage response =
                    await client.PostAsJsonAsync("api/v1/repos", createParams);

                if (response.StatusCode != System.Net.HttpStatusCode.OK)
                    throw new Exception(string.Format(
                        "API Status Code {0}. Expected OK.", response.StatusCode));

                return await response.Content.ReadAsAsync<Repository>();
            }
        }

        public static async Task<Repository> RenameRepository(string repositoryName, Rename renameParam)
        {
            HttpClient client = GetHttpClient();
            string uri = string.Format("api/v1/repos/{0}", repositoryName);
            using (client)
            {
                HttpResponseMessage response =
                    await client.PutAsJsonAsync(uri, renameParam);

                if (response.StatusCode != System.Net.HttpStatusCode.OK)
                    throw new Exception(string.Format(
                        "API Status Code {0}. Expected OK.", response.StatusCode));

                return await response.Content.ReadAsAsync<Repository>();
            }
        }

        public static async Task DeleteRepository(string repositoryName)
        {
            HttpClient client = GetHttpClient();
            string uri = string.Format("api/v1/repos/{0}", repositoryName);
            using (client)
            {
                HttpResponseMessage response =
                    await client.DeleteAsync(uri);

                if (response.StatusCode != System.Net.HttpStatusCode.NoContent)
                    throw new Exception(string.Format(
                        "API Status Code {0}. Expected NoContent.", response.StatusCode));
            }
        }
    }
}
