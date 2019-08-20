<#import "navadmin.ftl" as a>
<@a.page>


<div class="col">
    <h4 class="text-left"><p class="font-weight-light">Products </p></h4>
    <hr>
    <table class="table table-borderless table-sm">
        <thead>
        <tr>
            <th scope="col">#id</th>
            <th scope="col">Product name</th>
            <th scope="col">Product price</th>
            <th scope="col">Product quantity</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#if productslist?has_content>
            <#list productslist as product>
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>$${product.getPrice()} $</td>
                    <td> ${product.getQuantity()?cap_first}
                    <td> <a href="" class="btn btn-primary btn-sm"> Edit </a></td>
                </tr>
            </#list>

        </#if>
        </tbody>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Add</button>
            <form class="dropdown-menu p-4" aria-labelledby="dropdownMenu2" action="/admin/products/save" method="post" id="newProduct">
                <div class="form-group">
                    <label for="1">Product Name</label>
                    <input type="text" class="form-control" id="1" name="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="2">Product Price</label>
                    <input type="text" class="form-control" id="2" name="price" placeholder="Price">
                </div>
                <div class="form-group">
                    <label for="3">Product Quantity</label>
                    <input type="text" class="form-control" id="3" name="quantity" placeholder="Quantity">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </table>

</div>
</@a.page>

