package com.velazco.velazco_back.dto.roles.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto {
  private Long id;
  private String name;
  private Long count;
}
