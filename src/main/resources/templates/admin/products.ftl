<#import "navadmin.ftl" as a>
<@a.page>
    <div class="col">


    <div class="ibox">
    <div class="ibox-content">
        <div class="pull-right">
            <button type="button" class="btn btn-success btn-sm" id="addProduct" data-toggle="modal" data-target="#productModal">Add<span class="glyphicon glyphicon-plus"></span></button>
        </div>
        <h5>Products</h5>
        <div  id="alertSuccess" class="alert alert-success fade">
            <button type="button" class="close">&times;</button>
            <p>Product Added!</p>
        </div>
        <table class="table table-striped table-borderless table-sm display compact dataTable" id="productTable">
        <thead>
        <tr>
            <th class="th-sm">#id</th>
            <th class="th-sm">Product name</th>
            <th class="th-sm">Product price</th>
            <th class="th-sm">Product quantity</th>
            <th class="th-sm"></th>
        </tr>
        </thead>
        <tbody >
        <#if productslist?has_content>
            <#list productslist as product>
                <tr id="${product.getId()}">
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td >${product.getQuantity()}</td>
                    <td>
                        <a href="/admin/product/delete/${product.getId()}" id="deleteProduct" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"></span></a>
                        <button type="button" class="btn btn-info btn-sm" id="editProduct" data-toggle="modal" data-target="#productModal"><span class="glyphicon glyphicon-edit"></span></button>
                    </td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
        <div class="modal fade" id="productModal" tabindex="-1" role="dialog"  aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-left">Edit Product</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" action="/admin/products/save" id="productForm" method="post" >
                            <div class="form-group" id="addProductId">
                                <label for="id"> Product ID</label>
                                <input type="number" name="productId" id="id" value="" class="form-control" placeholder="" readonly>
                            </div>
                            <div class="form-group">
                                <label for="name" >Product Name</label>
                                <input type="text" id="name" name="name" value="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="price" >Product Price</label>
<#--                                <input type="number" id="price" name="price" step="any" value="" class="form-control">-->

                                <input type="number" id="price" name="price" step="any" value="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="quantity">Product Quantity</label>
                                <input type="number" id="quantity" name="quantity" value="" class="form-control">
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-info btn-sm" >Save</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</div>
</div>
 </div>
    <div id="alert" class="alert fade">
        <button type="button" class="close">&times;</button>
        <h4 class="alert-heading" style="text-align: center"></h4>
    </div>
</@a.page>

