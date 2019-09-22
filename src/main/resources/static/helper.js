$(document).ready(function() {
    /*
    Table settings
     */
    $('.dataTable').DataTable({
            "scrollY": "60vh",
            "scrollCollapse": true,
            "pageLength": 50,
        });


    $("#loginButton, #logout").click(function () {
        $.each(Cookies.get(), function (x) {
            Cookies.remove(x);
        });
        Cookies.set('cartSize', 0);
    });

    /*Change order status*/
    $('#orderTable tbody').on('click', '#ship', function (event) {
        event.preventDefault();
        let Row = $(this).parent().siblings(":first").text();
        $.ajax({
            type: 'GET',
            url: '/admin/setstatus/' + Row,
            success: function (response) {
                $('#' + Row).replaceWith($('#' + Row, $(response)));
                toggleAlert("Order has been shipped", "alert-success");
            }
        });
    });

    /*
    Re-use product modal for Edit/Add
     */
    $(document).on("click", "#editProduct", function () {
        var currentRow = $(this).closest("tr");
        $('#id').val(currentRow.find("td:eq(0)").text());
        $('#name').val(currentRow.find("td:eq(1)").text());
        var price = currentRow.find("td:eq(2)").text();
        $('#price').val(price.replace(',','.'));
        $('#quantity').val(currentRow.find("td:eq(3)").text());
    });

    $(document).on("click", "#addProduct", function () {
        $(".modal-title").text("Add product");
        $("#addProductId").hide();
    });

    $(document).on('hidden.bs.modal', function () {
            $(".modal-title").text("Edit product");
            $("#addProductId").show();
            $('form :input').val('');
        });


    /*
    Add new product by admin
     */
    $('#productForm').submit(function (event) {
        event.preventDefault();
        var form = $(this);
        var post_url = form.attr('action');
        var post_data = form.serialize();
        $.ajax({
            type: 'POST',
            url: post_url,
            data: post_data,
            success: function (response) {
                if (form.find("#id").val() === "") {
                   let Row = parseInt($('#productTable tr:last').attr('id'), 10) + 1;
                    $('#productTable  > tbody:last').append($('#' + Row, $(response)));
                    toggleAlert("Product Added!", "alert-success");
                } else {
                   let Row = form.find("#id").val();
                    $('#' + Row).replaceWith($('#' + Row, $(response)));
                    toggleAlert("Product Updated!", "alert-success");
                }
                $('#productModal').modal('hide');
            }
        });
    });


    /*Delete product by admin*/
    $(document).on('click', '#deleteProduct', function (event) {
        event.preventDefault();
        let Row = $(this).closest('tr').attr('id');
        $.ajax({
            type: 'GET',
            url: '/admin/product/delete/' + Row,
            success: function () {
                $('#' + Row).remove();
                toggleAlert("Product Deleted!", "alert-danger");
            }
        });
    });


    /*Add product to cart*/
    $(document).on("click", ".btn-buy", function (event) {
        event.preventDefault();
        let productId = parseInt($(this).attr('id'));
        $.ajax({
            type: 'POST',
            url: '/productpage/addproduct/' + productId,
            cache: false,
            success: function () {
                setCookie(productId,true);
                $('#' + productId + '.btn-buy').prop('disabled', true);
                setTotalCartQuantity(1);
                toggleAlert("Product Added!", "alert-success");
            }
        });
    });


    /*
    Remove product from  cart
     */
    $(document).on('click', '#remove', function (event) {
        event.preventDefault();
        let cartId = $(this).parent().attr('id');
        $.ajax({
            url: '/cart/remove/' + cartId,
            type: 'POST',
            cache: false,
            success: function (response) {
                Cookies.remove(cartId);
                $('#' + cartId + '.btn-buy').removeAttr("disabled");
                setTotalCartQuantity($(response).find('.ibox :input'), "refresh");
                toggleAlert("Product deleted!", "alert-danger");
                $("#rowId" + cartId).remove();
                $('#cartBox').replaceWith($('#cartBox', $(response)));
            }
        });
    });

    /*Refresh cart */
    $(document).on('click', '#refresh', function (event) {
            event.preventDefault();
            let cartId = $(this).parent().attr('id');
            $.ajax({
                type: 'POST',
                url: '/cart/refreshProduct/' + cartId,
                data: 'cartCount=' + $("#rowId" + cartId + " input").val(),
                cache: false,
                success: function (response) {
                    setTotalCartQuantity($(response).find('.ibox :input'), "refresh");
                    $("#rowId" + cartId).replaceWith($("#rowId" + cartId, $(response)));
                    $('#cartBox').replaceWith($('#cartBox', $(response)));
                    toggleAlert("Product Updated!", "alert-success");
                }
            });
        });


    /*Checkout*/
    $(document).on("click", 'a[href="/cart/checkout"]', function (event) {
            event.preventDefault();
            $.ajax({
                type: 'GET',
                url: '/cart/checkout',
                cache: false,
                success: function (response) {
                    var result = $(response).find('#response').html();
                    if (result.indexOf("Order") >= 0) {
                        $.each(Cookies.get(), function (id) {Cookies.remove(id)});
                        $('#cartContainer').replaceWith($('#cartContainer', $(response)));
                        $('#cartBox').replaceWith($('#cartBox', $(response)));
                        setTotalCartQuantity(0, "refresh");
                        toggleAlert(result, "alert-success");

                    } else if (result.indexOf("Not") >= 0) {
                        toggleAlert(result, "alert-danger")
                    }
                }
            });
        });

    /*Cookie getter*/
    function getCookie() {return parseInt(Cookies.get('cartSize'));}

    /*Cookie getter*/
    function setCookie(key,value) {
        return Cookies.set(key,value);
    }

    /*Set cart size via cookies*/
    function setTotalCartQuantity(value) {
        let cartSize =isNaN(getCookie())?0: getCookie();
        let arrNumber = [];

        if (value === 1){
            arrNumber.push(value,cartSize);
        }else{
            $(value).filter(':input').each(function () {
                let number = Number($(this).val());
                arrNumber.push(number);
            });
        }
        cartSize = arrNumber.reduce((a, b) => a + b, 0);
        setCookie('cartSize', cartSize);
        return $(".cartSize").text(getCookie());
     }

    /*alert*/
    function toggleAlert(message, type) {
        $('#alert').addClass('in ' + type);
        $('#alert h4').text(message);
        $("#alert").fadeTo(700, 500).slideUp(500, function () {
            $('#alert').removeClass('in ' + type);
        });
    }

    $.each(Cookies.get(), function (id, value) {
        $('#' + id + '.btn-buy').prop('disabled', value);
    });

    $.each($(".cartSize"), function() {
        $(this).text(getCookie());
    });
});