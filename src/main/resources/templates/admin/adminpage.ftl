<#import "navadmin.ftl" as a>
<@a.page>
<div class="col">
    <div class="ibox">
    <div class="ibox-content">

            <h5>Users</h5>
            <table class="table table-striped table-borderless table-sm display compact dataTable">
    <thead>
        <tr>
            <th class="th-sm">#id</th>
            <th class="th-sm">User name</th>
            <th class="th-sm">$Balance</th>
            <th class="th-sm">Orders</th>
            <th class="th-sm"></th>
        </tr>
    </thead>
        <tbody>
    <#if userList?has_content>
        <#list userList as user>
            <tr >
                <td>${user.getId()}</td>
                <td><a href="/admin/account/${user.getId()}">${user.getUsername()}</a></td>
                <td>${user.getBalance()} $</td>
                <td>${user.getOrders()?size}</td>
                <td><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#userModal${user.getId()}"><span class="glyphicon glyphicon-edit"></span></button></td>
            </tr>
                <div id="userModal${user.getId()}" class="modal fade " role="dialog">
                    <div class="modal-dialog" id="${user.getId()}">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title text-left">Edit User</h4>
                            </div>
                            <div class="modal-body">
                                <form action="/admin/account/edit/${user.getId()}" method="post" role="form">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label >User name</label>
                                            <input type="text" name="userName" placeholder="${user.getUsername()}" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label >Balance</label>
                                            <input type="number" name="newBalance" placeholder="${user.getBalance()}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-info btn-sm">Save</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </#list>
    </#if>
        </tbody>
    </table>
</div>
    </div>
</div>
    <div id="alert" class="alert fade">
        <button type="button" class="close">&times;</button>
        <h4 class="alert-heading" style="text-align: center"></h4>
    </div>
</@a.page>

