# Introduction

This folder contains the load tests for the AAS Registry.
The tool used for the load testing is `https://locust.io/`.

# Load test

The current implemented load test does the following:

   - Creates a shell
   - Retrieves the created shell by id
   - Lookups the shell by specific asset ids

To reduce the complexity, authentication is disabled.

# Executing the test

The `docker-compose.yml` all relevant services to execute the load test.

   - AAS Registry (latest INT version)
   - PostgreSQL Database as persistence for the AAS Registry
   - Locust Master for the Webui
   - Locust Worker for the load test execution

# Run the load test

   1. Execute `docker-compose up -d`
   2. Open the Locust WebUI `http://localhost:8090`
   3. In the opened form enter the following:
         - Number of users = 100 (=> 10 req/s)
         - Spawn rate      = 5
         - Host            = http://host.docker.internal:4242
   4. Press Start. Locust will now execute the load test as long as you wish.
   5. You can stop the test at anytime through the UI and grab the statistics.

# Local development

The steps for local development of the load tests are:

   1. Ensure python3 is installed
   2. Run `pip3 install -r requirements.txt`
   3. Modify the script
   4. Run `locust -f ./locust/locustfile.py --headless --users 1 --spawn-rate 1 -H http://host.docker.internal:4242`
