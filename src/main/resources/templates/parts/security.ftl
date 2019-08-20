<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    test = Session.SPRING_SECURITY_CONTEXT.authentication.principal

    name = test.getUsername()
    >
<#else>
    <#assign
    name = "unknown"
    >
</#if>
