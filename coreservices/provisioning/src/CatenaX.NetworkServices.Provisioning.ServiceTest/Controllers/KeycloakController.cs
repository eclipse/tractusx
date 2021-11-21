using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;

using Keycloak.Net;
using Keycloak.Net.Models.Groups;
using CatenaX.NetworkServices.Provisioning.Keycloak;

using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Keycloak.Net.Models.RealmsAdmin;

namespace CatenaX.NetworkServices.Provisioning.ServiceTest.Controllers
{
    [ApiController]
    [Route("api/provisioning")]
    public class KeycloakController : ControllerBase
    {
        private static string TRIGGERGROUP = "Onboarding";
        private static string CERTCLIENT = "urn:federation:MicrosoftOnline";
        private static string CERTATTRIBUTE = "saml.signing.certificate";
        private readonly ILogger<KeycloakController> _logger;
        private readonly KeycloakClient _Client;
        private readonly IKeycloakAccess _KeycloakAccess;
        public KeycloakController(ILogger<KeycloakController> logger, IKeycloakFactory keycloakFactory, IKeycloakAccess keycloakAccess)
        {
            _Client = keycloakFactory.CreateKeycloakClient();
            _KeycloakAccess = keycloakAccess;
            _logger = logger;
        }
        [HttpGet]
        [Route("realms/{realm}/isonboarding")]
        public async Task<ActionResult<bool>> CheckOnboardingGroup(string realm)
        {
            try
            {
                IEnumerable<Group> groups = await _Client.GetGroupHierarchyAsync(realm,null,null,TRIGGERGROUP);
                return groups.Any(group => {
                    return group.Name == TRIGGERGROUP;
                });
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("realms/{realm}/groups")]
        public async Task<ActionResult<IEnumerable<Group>>> GetGroups(string realm)
        {
            try
            {
                return new ActionResult<IEnumerable<Group>>(await _Client.GetGroupHierarchyAsync(realm));
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("realms/{realm}/groups/{group}")]
        public async Task<ActionResult<Group>> GetGroup(string realm,string group)
        {
            try
            {
                var _group = await _KeycloakAccess.GetGroupAsync(realm,group);
                if (_group != null)
                {
                    return new ActionResult<Group>(_group);
                }
                return new NotFoundResult();
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }

        [HttpGet]
        [Route("realms/{realm}/deleteonboarding")]
        public async Task<ActionResult> DeleteOnboardingGroup(string realm)
        {
            try
            {
                var group = await _KeycloakAccess.GetGroupAsync(realm,TRIGGERGROUP);
                if (group != null)
                {
                    await _KeycloakAccess.DeleteGroupAsync(realm,group.Id);
                    return new OkResult();
                }
                return new NotFoundResult();
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("realms")]
        public async Task<ActionResult<IEnumerable<Realm>>> GetRealms()
        {
            try
            {
                return new ActionResult<IEnumerable<Realm>>(await _KeycloakAccess.GetRealmsAsync());
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("onboardingrealms")]
        public async Task<ActionResult<IEnumerable<string>>> GetOnboardingRealms()
        {
            try
            {
                return new ActionResult<IEnumerable<string>>((await _KeycloakAccess.GetOnboardingRealmGroupsAsync(TRIGGERGROUP)).Select(x => x.Item1._Realm));
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("realms/{realm}/cert")]
        public async Task<ActionResult<string>> GetSamlCert(string realm)
        {
            try
            {
                return new ActionResult<string>(await _KeycloakAccess.GetSamlDescriptorCertAsync(realm));
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
        [HttpGet]
        [Route("realms/{realm}/createclient")]
        public async Task<ActionResult> CreateFederationClient(string realm)
        {
            try
            {
                await _KeycloakAccess.CreateFederationClient(realm);
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
