<#macro page>
<#import "../parts/common.ftl" as c>
<@c.page>
    <#include "../parts/navbar.ftl">
    <div class="d-flex" id="wrapper">
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="sidebar-heading">Admin Dashboard</div>
            <div class="list-group list-group-flush">
                <a href="/admin/users" class="list-group-item list-group-item-action bg-light">Users</a>
                <a href="/admin/products" class="list-group-item list-group-item-action bg-light">Products</a>
                <a href="/admin/orders" class="list-group-item list-group-item-action bg-light">Orders</a>
            </div>
        </div>

        <div class="container">
            <#nested>
        </div>
    </div>
</@c.page>
</#macro>
