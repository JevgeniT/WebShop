
<#import "common.ftl" as c>


<@c.page>
    <#include "navbar.ftl">

    <div class="container">

        <h2 class="text-center"><p class="font-weight-light"> Account details</p></h2>
        <hr>
        <div class="row">
            <div class="col-3">

                <h4 class="text-lg-left"><p class="font-weight-light">Customer</p></h4>
                <hr>
                <div>Username : ${name}</div>

                <div>Role:  ${role}</div>

                <div>Available balance : ${balance}</div>

            </div>
            <hr>
            <div class="col">
                <h4 class="text-left"><p class="font-weight-light">Order History</p></h4>
                <hr>
                <table class="table table-borderless table-sm">
                    <thead>
                    <tr>
                        <th scope="col">#id</th>
                        <th scope="col">Order date</th>
                        <th scope="col">Total price</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>

                        <#if orders?has_content>

                            <#list orders as orders>
                                <tr>
                                <td>${orders.getId()}</td>
                                <td>${orders.getOrderDate()}</td>
                                <td>$${orders.getTotalPrice()}</td>
                                <td> Status </td>
                                </tr>
                            </#list>

                        </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@c.page>

