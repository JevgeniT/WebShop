<#import "navadmin.ftl" as a>
<@a.page>
    <div class="container">

        <h2 class="text-center"><p class="font-weight-light"> Account details</p></h2>
        <hr>
        <div class="row">
            <div class="col-3">
                <h4 class="text-lg-left"><p class="font-weight-light">Customer</p></h4>
                <hr>
                <div>Username : ${singleUser.getUsername()}</div>
                <div>Role:  ${singleUser.getRoles()?join(", ")?lower_case?cap_first}</div>
                <div>Available balance : ${singleUser.getBalance()}</div>
<#--                init modal -->
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">Edit</button>
<#-- -->
                <!-- Modal -->
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title text-left">Edit User</h4>
                            </div>
                            <div class="modal-body">
                                <div>
                                    <form class="form-inline" method="post" action="/admin/setbalance/${userId}">
                                        <div class="form-group mb-2">
                                            <span class="input-group-text" id="basic-addon3">Balance:   </span>
                                            <input type="text" class="form-control" name="newBalance">
                                            <button href="" type="submit" class="btn btn-outline-dark">Set</button>
                                        </div>
                                    </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <hr>

            </div>
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
                        <th scope="col">Ship Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if singleUser.getOrders()?has_content>
                        <#list singleUser.getOrders() as orders>
                            <tr>
                                <td>${orders.getId()}</td>
                                <td>${orders.getOrderDate().toString()?replace("T"," ")}</td>
                                <td>$${orders.getTotalPrice()}</td>
                                <td> ${orders.getStatus()?cap_first}</td>
                                <td><#if orders.getShipDate()?has_content>${orders.getShipDate().toString()?replace("T"," ")}<#else>Not yet</#if></td>
                            </tr>
                        </#list>
                            <#else >
                            <tr>
                                <td class="align-content-center">No orders yet</td>
                            </tr>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@a.page>

