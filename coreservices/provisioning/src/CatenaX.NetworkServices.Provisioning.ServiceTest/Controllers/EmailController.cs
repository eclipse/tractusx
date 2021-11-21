using System;
using System.Net;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

using CatenaX.NetworkServices.Provisioning.Keycloak;
using CatenaX.NetworkServices.Provisioning.Mail;

namespace CatenaX.NetworkServices.Provisioning.ServiceTest.Controllers
{
    [ApiController]
    [Route("api/provisioning")]
    public class EmailController
    {
        private readonly ILogger<EmailController> _logger;
        private readonly IKeycloakAccess _KeycloakAccess;
        private readonly IUserEmail _UserEmail;
        public EmailController(ILogger<EmailController> logger, IKeycloakAccess keycloak, IUserEmail userEmail)
        {
            _logger = logger;
            _KeycloakAccess = keycloak;
            _UserEmail = userEmail;
        }
        [HttpGet]
        [Route("realms/{realm}/sendInvitations")]
        public async Task<ActionResult> SendInvitations(string realm)
        {
            try
            {
                var users = await _KeycloakAccess.GetUsersAsync(realm);
                await Task.WhenAll(users.Select( user => _UserEmail.SendMailAsync(user.Email,user.FirstName,user.LastName,realm)));
                return new OkResult();
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
    }
}
