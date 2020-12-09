package com.user.usermodule.usermoduleapi.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.usermodule.usermoduleapi.dto.UserAudiTrailDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.regex.Pattern;


/**
 * UserLoggingAdvice
 * @author – Sasiprabu
 */
@Aspect
@Component
public class UserLoggingAdvice {

    KafkaTemplate<String, UserAudiTrailDto> kafkaTemplate;
    private static final String USER_MODULE_TOPIC = "UserModuleApi";

    @Lazy
    @Autowired
    public UserLoggingAdvice(KafkaTemplate<String, UserAudiTrailDto> kafkaTemplate) {
        super();
        this.kafkaTemplate = kafkaTemplate;
    }

    @Around("@annotation(com.user.usermodule.usermoduleapi.advice.UserAuditLogging)")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        UserAudiTrailDto userAuditDto = new UserAudiTrailDto();
        ObjectMapper mapper = new ObjectMapper();
        long milliSeconds = System.currentTimeMillis();
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] array = pjp.getArgs();
        java.sql.Date date = new java.sql.Date(milliSeconds);
        java.sql.Time time = new java.sql.Time(milliSeconds);
        InetAddress myHost = InetAddress.getLocalHost();
        String charToDel = "{[]}";
        String pattern = "[" + Pattern.quote(charToDel) + "]";
        Object object = pjp.proceed();
        userAuditDto.setUserName(myHost.getHostName());
        userAuditDto.setEventRequest(mapper.writeValueAsString(array).replaceAll(pattern, ""));
        userAuditDto.setHostIp(myHost.getHostAddress());
        userAuditDto.setExecutionDate(date.toString());
        userAuditDto.setExecutionTime(time.toString());
        userAuditDto.setEventMethodName(methodName);
        userAuditDto.setEventType("USER-MODULE-API");
        userAuditDto.setEventSubType(methodName);
        userAuditDto.setEventResult(mapper.writeValueAsString(object).replaceAll(pattern, ""));
        kafkaTemplate.send(USER_MODULE_TOPIC, userAuditDto);
        return object;
    }
}

