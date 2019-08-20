<#import "navadmin.ftl" as a>
<@a.page>
        <div class="col" >
            <h4 class="text-left"><p class="font-weight-light">Orders</p></h4>
            <hr>
            <table class="table table-borderless table-sm">
                <thead>
                <tr>
                    <th scope="col">#id</th>
                    <th scope="col">Order date</th>
                    <th scope="col">Order Price</th>
                    <th scope="col">Order Status</th>
                    <th scope="col"> Shipping date </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <#if orders?has_content>
                    <#list orders as order>
                        <tr>
                            <td>${order.getId()}</td>
                            <td>${order.getOrderDate().toString()?replace("T"," ")}</td>
                            <td>${order.getTotalPrice()}</td>
                            <td>${order.getStatus()?cap_first}</td>
                            <td><#if order.getShipDate()?has_content>${order.getShipDate()}<#else>Not yet</#if></td>
                            <td> <a href="/admin/setstatus/${order.getId()}" class="btn btn-primary btn-sm"> Ship </a></td>
                        </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
</@a.page>