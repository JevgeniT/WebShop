<#macro page>
<#import "../parts/common.ftl" as c>
<@c.page>
    <#include "../parts/navbar.ftl">
    <div class="container">
        <h3 style="text-align:center">Admin Page</h3>
        <!-- Nav tabs -->
        <ul class="nav nav-pills justify-content-center">
            <li class="nav-item"><a  class="nav-link" href="/admin/users" >Users</a></li>
            <li class="active"><a  class="nav-link" href="/admin/products">Products </a></li>
            <li class="active"><a  class="nav-link" href="/admin/orders">Orders </a></li>
        </ul>
        <div class="container">
            <#nested>
        </div>

    </div>
</@c.page>
</#macro>