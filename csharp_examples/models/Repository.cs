using System;

namespace Csharp_examples.Models
{
    public class Repository
    {
        public RepId RepId { get; set; }
        public Owner Owner { get; set; }
        public string Name { get; set; }
        public Guid Guid { get; set; }
        public string Server { get; set; }
    }
}
