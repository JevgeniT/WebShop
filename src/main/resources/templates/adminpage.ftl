
<#import "parts/common.ftl" as c>


<@c.page>
    <#include "parts/navbar.ftl">
    <h1>AdminPAge</h1>

<div class="container">

    <hr>
    <div class="col">
        <h4 class="text-left"><p class="font-weight-light">User List</p></h4>

        <table class="table table-sm">
            <thead>
            <tr>
                <th scope="col">#id</th>
                <th scope="col">User name</th>
                <th scope="col">Balance </th>
                <th scope="col">Orders </th>
            </tr>
            </thead>
            <tbody>

            <#if test?has_content>
                <#list test as test>
                    <td>${test.getId()}</td>
                    <td>${test.getUsername()}</td>
                    <td>${test.getBalance()}</td>

                    <td>
                        <a href="/admin/users/${test.getId()}/">${test.getOrders()?size}</a>
                    </td>
<#--                    <td>${test.getS}</td>-->
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</div>
</@c.page>

