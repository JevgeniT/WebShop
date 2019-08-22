<#import "navadmin.ftl" as a>
<@a.page>
    <div class="col">
        <h4 class="text-left"><p class="font-weight-light"> Users </p></h4>
        <hr>
        <table class="table table-borderless table-sm">
            <thead>
                <tr>
                    <th scope="col">#id</th>
                    <th scope="col">User name</th>
                    <th scope="col">Balance</th>
                    <th scope="col">Orders</th>
                </tr>
            </thead>
            <tbody>
            <#if userList?has_content>
                <#list userList as user>
                    <tr >
                        <td>${user.getId()}</td>
                        <td>${user.getUsername()}</td>
                        <td>${user.getBalance()} $</td>
                        <td>${user.getOrders()?size}</td>
                        <td>
                            <a  class="btn btn-primary btn-sm" href="/admin/users/${user.getId()}/">Edit</a></td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@a.page>

