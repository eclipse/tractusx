output "catenax_eventhubs_namespace_name" {
  value = module.eventhubs_namespace.name
}

output "catenax_events_topic" {
  value       = module.eventhub_catenax_events.eventhub_name
  description = "The Event Hubs name (Kafka topic) for Catena-X events."
}

output "catenax_events_send_primary_connection_string" {
  value       = module.eventhub_catenax_events.send_primary_connection_string
  description = "The primary connection string to send Catena-X events."
  sensitive   = true
}

output "catenax_events_receive_primary_connection_string" {
  value       = module.eventhub_catenax_events.receive_primary_connection_string
  description = "The primary connection string to receive Catena-X events."
  sensitive   = true
}

output "prs_app_insights_connection_string" {
  value       = module.prs_application_insights.connection_string
  sensitive   = true
  description = "The Connection String for Application Insights."
}

output "prs_db_fqdn" {
  value       = module.prs_postgresql.fqdn
  description = "The PostgreSQL FQDN."
}

output "prs_db_administrator_username" {
  value       = module.prs_postgresql.administrator_username
  description = "The administrator user login name."
}

output "prs_db_administrator_login_password" {
  value       = module.prs_postgresql.administrator_login_password
  description = "The administrator user password."
  sensitive   = true
}

output "prs_db_name" {
  value       = module.prs_postgresql.db_name
  description = "The PostgreSQL database name."
}
