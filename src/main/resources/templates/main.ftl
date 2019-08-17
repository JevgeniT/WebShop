
<#import "parts/common.ftl" as c>


<@c.page>
    <#include "parts/navbar.ftl">
    <h1>Main page </h1>

    <#if word?has_content>
        ${word}
    </#if>
</@c.page>

