using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.OpenApi.Models;

using CatenaX.NetworkServices.Mailing.SendMail;
using CatenaX.NetworkServices.Mailing.Template;
using CatenaX.NetworkServices.Provisioning.Mail;
using CatenaX.NetworkServices.Provisioning.ActiveDirectory;
using CatenaX.NetworkServices.Provisioning.Keycloak;
using CatenaX.NetworkServices.Provisioning.Service.BusinessLogic;

namespace CatenaX.NetworkServices.Provisioning.Service
{
    public class Startup
    {
        private static string TAG = typeof(Startup).Namespace;
        private static string VERSION = "v1";
        public IConfiguration Configuration { get; }
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllers();
            services.AddHttpClient()
                    .AddSwaggerGen(c => c.SwaggerDoc(VERSION, new OpenApiInfo { Title = TAG, Version = VERSION }))
                    .AddSingleton<IClientToken, ClientToken>()
                    .AddTransient<IFederation, Federation>()
                    .AddTransient<IKeycloakFactory, KeycloakFactory>()
                    .AddTransient<IKeycloakAccess,KeycloakAccess>()
                    .AddTransient<ISendMail,SendMail>()
                    .AddTransient<ITemplateManager,TemplateManager>()
                    .AddTransient<IUserEmail,UserEmail>()
                    .AddTransient<IProvisioningService,ProvisioningService>()
                    .ConfigureMailSettings(Configuration.GetSection(UserEmail.ProviderPosition))
                    .ConfigureTemplateSettings(Configuration.GetSection(UserEmail.TemplatePosition))
                    .ConfigureUserEmailSettings(Configuration.GetSection(UserEmail.UserEmailPosition))
                    .ConfigureKeycloakSettings(Configuration.GetSection(KeycloakAccess.ConfigPosition))
                    .ConfigureKeycloakAccessSettings(Configuration.GetSection(KeycloakAccess.ConfigPosition))
                    .ConfigureClientSettings(Configuration.GetSection(ClientToken.ConfigPosition))
                    .ConfigureFederationSettings(Configuration.GetSection(Federation.ConfigPosition))
                    .ConfigureProvisioningSettings(Configuration.GetSection(ProvisioningService.ConfigPosition));
        }
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint(string.Format("/swagger/{0}/swagger.json",VERSION), string.Format("{0} {1}",TAG,VERSION)));
            }

            app.UseRouting();

            app.UseEndpoints(endpoints =>
                endpoints.MapControllers()
            );
        }
    }
}
