using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;

namespace CatenaX.NetworkServices.Provisioning.ServiceTest
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureAppConfiguration(appConfiguration => {
                    foreach(var source in appConfiguration.Sources) {
                        var fileSource = source as FileConfigurationSource;
                        if (fileSource != null) {
                            fileSource.ReloadOnChange = false;
                        }
                    }
                })
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
