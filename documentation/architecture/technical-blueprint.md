# Pre-Requisites
* Technology Portfolio:
  * Connector: OSS DataSpace Connector implementation from Fraunhofer
    * Creation of own branch for Catena-X in repository
    * Maintenance-Responsibility?
  * IdP
    * Azure AD
  * Portal: 
    * Portal-Platform: TBD -> Decision DevTeam, FOSS first
    * Frontend: 
      * Technical: HTML,CSS,JS. Framework: React (alt. Vue.js or Open UI5 tbd)
      * Mockup: Invision
    * Backend:
      * Spring Boot for the PoC // Quarkus (Microprofile) is preferred
  * Platform:
    * Containerize where possible:
      * Kubernetes as a service
      * Overall Guideline: </br> 
        Alignment on container base OS. </br>
        BMW proposal: Not select one specific OS but agree on CIS Benchmarks und CIS Linux Certification. --https://www.cisecurity.org/
        * ToDo: Check if AKS is in line with GaiaX / IDS guidelines / requirements.
    * Database:
      * PostgreSQL as a Seruce
  * API Hub (optional, to discuss)
    * Swagger UI + spec. via swagger.json
* Infrastructure
  * Dev
    * Tractus-X
      * Git (inkl. GitHub Actions)
      * Wiki
      * Issue-Tracker
      * Mailing-List
      * Slack
    * Microsoft-Infra:
      * Swagger-UI
    * Test-Data-Management
      * Data Simulation / Generation tool tbd
  * Runtime
* Conceptual
  * Formats
    * OpenAPI for interface and data specifications -> swagger ui
