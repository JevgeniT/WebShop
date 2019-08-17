
<#import "parts/common.ftl" as c>


<@c.page>
    <#include "parts/navbar.ftl">
    <h1>UserPage</h1>

    <div class="container">

        <h2 class="text-center"><p class="font-weight-light"> Account details</p></h2>
        <hr>
        <div class="row">
            <div class="col-3">
                <h4 class="text-lg-left"><p class="font-weight-light">Customer</p></h4>
                <hr>
                <div>Username : ${test.getUsername()}</div>
                <div>Role:  ${test.getRoles()?join(", ")}</div>
                <div>Available balance : ${test.getBalance()}</div>
                <a href="/admin/setbalance/${test.getId()}" class="btn btn-primary"> Add Balance </a>
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

                    <#if test.getOrders()?has_content>
                        <#list test.getOrders() as orders>
                            <tr>
                                <td>${orders.getId()}</td>
                                <td>${orders.getOrderDate().toString()?replace("T"," ")}</td>
                                <td>$${orders.getTotalPrice()}</td>
                                <td> ${orders.getStatus()?cap_first}
                                    <a href="/admin/setstatus/${orders.getId()}" class="btn btn-primary"> Ship </a>
                                </td>


                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@c.page>

