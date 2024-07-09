package dev.aaiyvan.event.listener.extension.model.dto;

import dev.aaiyvan.event.listener.extension.model.type.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * AuditEvent is a data transfer object (DTO) class that represents an audit event.
 * It uses Lombok annotations for automatic generation of getters, setters, a builder, and constructors.
 * An audit event contains the following fields:
 * - userUUID: the UUID of the user associated with the event
 * - action: the action performed that triggered the event
 * - status: the status of the event (e.g., SUCCESS or FAIL)
 * - startedAt: the time when the event started
 * - finishedAt: the time when the event finished
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuditEvent {

  String userUUID;
  String action;
  Status status;
  LocalDateTime startedAt;
  LocalDateTime finishedAt;
}