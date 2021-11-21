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
    [Route("api/provisioning")]
    public class CreateFederationController : ControllerBase
    {
        private readonly ILogger<CreateFederationController> _logger;
        private readonly IFederation _Federation;
        public CreateFederationController(ILogger<CreateFederationController> logger, IFederation logic)
        {
            _logger = logger;
            _Federation = logic;
        }
        [HttpGet]
        [Route("realms/{realm}/createfederation")]
        public async Task<ActionResult<Token>> ExecuteCreateFederation(string realm)
        {
            try
            {
                var parameters = new Dictionary<string,string> {
                    { "realm", realm },
                    { "base", "catenaxdev003akssrv.germanywestcentral.cloudapp.azure.com" },
                    { "cert", "MIIClTCCAX0CBgF8elgcMjANBgkqhkiG9w0BAQsFADAOMQwwCgYDVQQDDANibXcwHhcNMjExMDEzMTU0NzQ3WhcNMzExMDEzMTU0OTI3WjAOMQwwCgYDVQQDDANibXcwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCAIDmdR77KfVpjUja93M4OJzeFSD3BHfYvLFAnDncGhU1RYXKSPiubKQ9rU0AhgjEz7BpUG0npRY049l6vqUsCcc1RFrZJhbOjkDHRFzM5Z2nIN9SOXrJ609ULYdBiai7Me426/TDPQCTgZaD5XhhD0SLijID9iRHfFpSUh/nDasYzi1D++Ycm7ukoj//FtNwQb7E3L+/X7lQeidOCCqmwJ0IabM05hba+tb7gZA7HyDARq5csjWGXNNDHec/wqDC+0vzle27lABQ+vz1OQfWlhhKtQeR3SEPgKH0YS0AvmdhGjlsB01JaLFlu/4mJHMY8q1ZpiWfhes+dUH7jwMZbAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAE8RdKDmXqe2XhXo73Co1PHajk06jMLHELaAnm4gSDUgZWGijVRL3wxwgfLUWauiix3W9oBbn7y1Xe6q39gZSHgTyqP1eCkIXYoMKn3HgWjAT9XJmi3xn5juNWsxxy1e6MmKHStJyaiEEwwDKgKnRdT8SVRUQ4ZhPSsYNnSyRQEMuc9/z3uuY3A2XuLEnDRMx8BLRf75l0xI9GBj7kJkufewu6MsuhDdnBHXkpyK4yBV/uPIYyjuEO8dId8dmLgHJjdVSjs5g7XUA+G7mKitovAiAYwPUMMsduCiHGYI+BVuYCVToIoLv0CzXudgIFzENy3DfUrQvQCgtFCA91T4PA4=" }
                };
                await _Federation.CreateFederationAsync(parameters);
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
