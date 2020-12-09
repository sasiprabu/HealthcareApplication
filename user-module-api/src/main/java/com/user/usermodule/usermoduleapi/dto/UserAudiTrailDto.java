package com.user.usermodule.usermoduleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAudiTrailDto {

    private String userName;

    private String hostIp;

    private String eventType;

    private String eventSubType;

    private String eventRequest;

    private String eventResult;

    private String executionDate;

    private String executionTime;

    private String eventMethodName;
}