using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;

using CatenaX.NetworkServices.Provisioning.ActiveDirectory;
using CatenaX.NetworkServices.Provisioning.ActiveDirectory.Model;

using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace CatenaX.NetworkServices.Provisioning.ServiceTest.Controllers
{
    [ApiController]
    [Route("api/provisioning/token")]
    public class GetTokenController : ControllerBase
    {
        private readonly ILogger<GetTokenController> _logger;
        private readonly IClientToken _logic;
        public GetTokenController(ILogger<GetTokenController> logger, IClientToken logic)
        {
            _logger = logger;
            _logic = logic;
        }
        [HttpGet]
        public async Task<ActionResult<Token>> ExecuteGetToken()
        {
            try
            {
                var token = await _logic.GetTokenAsync();
                return token;
            }
            catch (Exception e)
            {
                _logger.LogError(e.ToString());
                return new StatusCodeResult((int)HttpStatusCode.InternalServerError);
            }
        }
    }
}
