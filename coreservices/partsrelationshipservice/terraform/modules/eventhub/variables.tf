variable "eventhub_namespace_name" {
  type        = string
  description = "Namespace name."
}

variable "name" {
  type        = string
  description = "Event hub name (Kafka topic name)."
}

variable "resource_group_name" {
  type        = string
  description = "Resource group to deploy in."
}

variable "partition_count" {
  type        = number
  default     = 2
  description = "Event hub partition count."
}

variable "message_retention" {
  type        = number
  default     = 7
  description = "Number of days to retain data, max 7."
}
